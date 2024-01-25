var express = require('express');
var fs = require('fs');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var app = express();

app.use(cookieParser());

// true : qs 모듈, false :query-string 모듈
app.use(bodyParser.urlencoded({extended: false}));

// 라우터
app.get('/', function(req, res){
    if(req.cookies.auth){
        res.send('<h1>로그인 성공</h1>');
    } else {
        res.send('<h1>로그인이 필요합니다</h1><br><a href="/login">로그인 하기</a>');
    }
});

// 로그인 화면 요청
app.get('/login', function(req, res){
    fs.readFile('login.html', function(error, data){
        // res.writeHead(200, {'Content-Type' : 'text/html'});
        // res.end(data);
        res.send(data.toString());
    });
});

// 로그인 요청 시 파라미터 처리
app.post('/login', function(req, res){ 
    var login = req.body.login;
    var password = req.body.password;

    console.log(login, password);
    console.log(req.body);

    if(login == 'user' && password == '1234'){
        res.cookie('auth', true);
        res.redirect('/');
    } else {
        res.send('<script>alert("로그인에 실패하였습니다"); history.back();</script>');
    }
});

app.listen(8080, function(){
    console.log('Server On');
});