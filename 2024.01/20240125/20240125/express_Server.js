var express = require('express');

// 서버를 생성
var app = express();

// request(요청)을 처리하는 방식
// app.use(function(req, res){
//     res.writeHead(200, {'Content-Type' : 'text/html'});
//     res.end('<h1>Express Server On!</h1>');
// });

// app.use(function(req, res){
//     var output = [];
//     for(var i = 0; i < 3; i ++){
//         output.push({count: i, name: 'name - ' + i});
//     }

//     res.send(output);
// });

// 미들웨어 설정
// app.use(function(req, res){
//     res.status(404).send('<h1>Error</h1>');
// });

// app.use(function(req, res){
//     var agent = req.header('User-Agent');
//     console.log(req.header);
//     console.log(agent);

//     if(agent.toLocaleLowerCase().match(/chrome/)){
//         res.send('<h1>Hello Chrome ...</h1>');
//     } else {
//         res.send('<h1>Hello Express ...</h1>');
//     }

// });

app.use(function(req, res){
    var name = req.query.name;
    var region = req.query.region;

    res.send('<h1>' + name + '-' + region + '</h1>');
});

// 서버 실행
app.listen(8080, function(){
    console.log('Express Server On');
});