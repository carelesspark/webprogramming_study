var http = require('http');
var fs = require('fs');
var socketio = require('socket.io');

var server = http.createServer(function(request,response){
    fs.readFile('singlePage.html',function(error,data){
            response.writeHead(200, { 'Content-Type': 'text/html' });
            response.end(data);
    });
}).listen(8080,'localhost',function(){
    console.log('Server On!');   
});

var io = socketio.listen(server);
io.sockets.on('connection', function (socket) {
    socket.on('message', function (data) {
        io.sockets.emit('message', data);
    });
});