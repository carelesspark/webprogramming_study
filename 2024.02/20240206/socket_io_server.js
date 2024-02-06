var fs = require('fs');

var server = require('http').createServer();
var io = require('socket.io').listen(server);

server.listen(8080,function () {
    console.log('Server Running at http://127.0.0.1:8080');
});

server.on('request',function(request,response){
    fs.readFile('socketPage2.html',function (error, data) {
        response.writeHead(200, { 'Content-Type': 'text/html' });
        response.end(data);
      });
});

io.on('connection',function(socket){
    console.log("소켓접속");

    var roomName = null;

    socket.on('join',function(data){
        console.log('roomName : ' + data);
        roomName = data;
        // roomName = data;
        // roomName = data;
        socket.join(data);
    });

    socket.on('message', function(data){
        console.log('roomName : ' + data.roomName);
        console.log('msg : ' + data.msg);
        io.sockets.to(roomName).emit('message', data.msg);
        // io.to(roomName).emit('message', data);
    });
});

