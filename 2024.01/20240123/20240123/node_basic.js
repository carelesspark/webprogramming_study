var http = require('http');

// // 서버 생성
// var server = http.createServer();

// // 서버 실행(포트 지정)
// server.listen(8080, function(){
//     console.log('서버가 실행되었습니다.');
// });

// // 서버 종료
// // server.close();

// var test = function(){
//     console.log('서버가 종료되었습니다.')
//     server.close();
// }

// setTimeout(test, 5000);

// ==============================================================================

// // 서버객체에 이벤트 연결
// server.on('request', function(){
//     console.log('Request On');
// });

// server.on('connection', function(){
//     console.log('Connection On');
// });

// server.on('close', function(){
//     console.log('Close On');
// });

// server.listen(8080, function(){
//     console.log('Server On');
// });


// ==============================================================================

var server = http.createServer(function(req, res){
    res.writeHead(200, {'Content-Type' : 'text/html'});
    res.end('<h1>Hello Node Server!</h1>');
});

server.listen(8080, function(){
    console.log('Server On');
});