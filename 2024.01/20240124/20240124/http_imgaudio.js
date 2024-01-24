var fs = require('fs');
var http = require('http');

http.createServer(function(req, res){
    fs.readFile('naver.png', function(error, data){
        res.writeHead(200, {'Content-Type' : 'image/jpeg'});
        res.end(data);
    });
}).listen(8080, function(){
    console.log('Server On! : 8080');
});

http.createServer(function(req, res){
    fs.readFile('sfdsf.mp3', function(error, data){
        res.writeHead(200, {'Content-Type' : 'audio/mp3'});
        res.end(data);
    });
}).listen(8090, function(){
    console.log('Server On! : 8090');
});