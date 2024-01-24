var http = require('http');

http.createServer(function(req, res){
    res.writeHead(200, {'Location' : 'http://www.naver.com'});
    res.end('<h1>Test - supervisor version3</h1>');
}).listen(8080, function(){
    console.log('Server On');
});