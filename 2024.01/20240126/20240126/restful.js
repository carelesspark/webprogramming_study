var express = require('express');
var fs = require('fs');
var bodyParser = require('body-parser');


var app = express();

var DummyDB = (function(){
    var DummyDB = {};   // 속성(변수)과 기능(함수) 정의
    var storage = [];   // [{....}.{.....}].{{....}}}
    var count = 1;

    DummyDB.get = function(id){ // 전체 조회, 특정 값 조회, 수정
        if(id){
            id = (typeof id == 'string') ? Number(id) : id;
            for(var i in storage){
                if(storage[i].id == id){
                    return storage[i];
                }
            }
        } else{
            return storage;
        }
    };
    DummyDB.insert = function(data){    // data형식은 객체 {key, ...} 
        data.id = count ++;             // {k:v , k:v, .....}
        storage.push(data);             // [{...}, {...}, {...}, ...]
        return data;
    };
    DummyDB.remove = function(id){
        id = (typeof id == 'string') ? Number(id) : id;
        for(var i in storage){
            if(storage[i].id == id){
                storage.splice(i, 1);   // 데이터 삭제
                return true;
            }
        }
        return false;
    };
    
    return DummyDB;
})();

app.use(bodyParser.urlencoded({extended: false}));

// board/:id >> board/10 get, put, delete   /   post

 // 전체 데이터요청
app.get('/user', function(req ,res){
    res.send(DummyDB.get());
});

 // 특정 데이터 요청
app.get('/user/:id', function(req ,res){
    res.send(DummyDB.get(req.params.id));
});

app.post('/user', function(req ,res){
    var name = req.body.name;
    var region = req.body.region;

    if(name && region){
        var user = {name: name, region: region};
        res.send(DummyDB.insert(user));
    } else {
        throw new Error('error');
    }
});
app.put('/user/:id', function(req ,res){
    var id = req.params.id;
    var name = req.body.name;
    var region = req.body.region;

    var item = DummyDB.get(id);
    item.name = name || item.name; // 최단 평가 연산
    item.region = region || item.region; // 최단 평가 연산

    res.send(item);
});
app.delete('/user/:id', function(req ,res){
    res.send(DummyDB.remove(req.params.id));
});

app.listen(8080, function(){
    console.log('Server On');
});