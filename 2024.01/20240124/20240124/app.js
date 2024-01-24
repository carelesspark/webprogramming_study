var http = require('http');
var fs = require('fs');
var url = require('url'); 
const path = require('path');


http.createServer(function(req, res){
    var pathName = url.parse(req.url).pathname;

    console.log(pathName);
    
    if(pathName == '/'){
        fs.readFile('index.html', function(error, data){    
            res.writeHead(200, {'Content-Type' : 'text/html'});
            res.end(data);
        });
    } else if(pathName = '/otherPage') {
        fs.readFile('otherPage.html', function(error, data){
            res.writeHead(200, {'Content-Type' : 'text/html'});
            res.end(data);
        });
    }
}).listen(8080, function(){
    console.log('Server On');
});