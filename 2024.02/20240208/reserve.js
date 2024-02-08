var socketio = require("socket.io");
var express = require("express");
var http = require("http");
var fs = require("fs");

var seats = [
  [1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
  [1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1]
];

// 웹 서버 생성
var app = express();
var server = http.createServer(app);

// 라우터 구성
app.get("/", function (req, res) {
  fs.readFile("reservePage.html", function (error, data) {
    res.send(data.toString());
  });
});

app.get("/seats", function (req, res) {
    res.send(seats);
});

// 웹 서버 실행
server.listen(8080, function () {
  console.log("Server On!");
});

// 소켓 서버 생성 및 실행
var io = socketio.listen(server);
io.sockets.on("connection", function (socket) {
    socket.on('reserve', function(data){
        seats[data.y][data.x] = 2;
        io.sockets.emit('reserve', data);
    });
});
