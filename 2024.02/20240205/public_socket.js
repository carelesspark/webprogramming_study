var http = require('http');
var fs = require('fs');
var socketio = require('socket.io');

var server = http.createServer(function(req, res){
    fs.readFile('SocketPage.html', function(error, data){
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(data);
    });
}).listen(8080, function(){
    console.log('Server On!');
});

// 소켓서버와 웹서버 설정 및 실행
var io = socketio.listen(server);
var id = 0;

io.sockets.on('connection', function(socket){

    id = socket.id;

    socket.on('rint', function(data){
        // public 통신
        // io.sockets.emit('smart', data);

        // broadcast 통신
        // socket.broadcast.emit('smart', data);

        // private 통신
        io.sockets.to(id).emit('smart', data);
    });
});
