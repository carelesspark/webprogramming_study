var http = require('http');
var fs = require('fs');
var socketio = require('socket.io');

var server = http.createServer(function(request,response){
    fs.readFile('socetPage2.html',function(error,data){
            response.writeHead(200, { 'Content-Type': 'text/html' });
            response.end(data);
    });
}).listen(8080,function(){
    console.log('Server On!');   
});

var io = socketio.listen(server);

io.on('connection',function(socket){
    console.log("소켓접속");

    var roomName = null;

    socket.on('join',function(data){
        console.log('roomName :' + data);
        roomName = data;
        socket.join(data);
    });

    socket.on('message',function(data){
        console.log('roomName :' + data.roomName);
        console.log('msg :' + data.msg);
        io.sockets.to(roomName).emit('message',"[" + data.nick + "]" +  data.msg);
        //io.to(roomName).emit('message',data);
    });
});

