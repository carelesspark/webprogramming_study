var fs = require('fs');
var http = require('http');

http.createServer(function(req, res){
    console.log('Server On!');
    fs.readFile('HTMLPage.html', function(error, data){
        res.writeHead(200, {'Content-Type' : 'text/html'});
        res.end(data);
    });
}).listen(8080);