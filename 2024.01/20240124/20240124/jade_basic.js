var http = require('http');
var fs = require('fs');
var jade = require('jade');

http.createServer(function(req, res){
    fs.readFile('jadePage.jade', function(error, data){
        var fn = jade.compile(data);
        res.writeHead(200, {'Content-Type' : 'text/html'});
        res.end(fn({
            name: 'Park Jong Hyeok',
            description: 'jade plus nodejs'
        }));
    });
}).listen(8080, function(){
    console.log('Server On');
});