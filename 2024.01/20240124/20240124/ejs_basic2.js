var http = require('http');
var fs = require('fs');
var ejs = require('ejs');

http.createServer(function(req, res){
    fs.readFile('ejsPage.ejs', 'utf-8', function(error, data){
        res.writeHead(200, {'Content-Type' : 'text/html'});
        res.end(ejs.render(data, {
            name: 'Park Jong Hyeok',
            description: 'ejs plus nodejs'
        }));
    });
}).listen(8080, function(){
    console.log('Server On');
});