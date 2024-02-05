var http = require("http");
var fs = require("fs");
var socketio = require("socket.io");

var server = http
  .createServer(function (req, res) {
    fs.readFile("SocketPage.html", function (error, data) {
      res.writeHead(200, { "Content-Type": "text/html" });
      res.end(data);
    });
  })
  .listen(8080, function () {
    console.log("Server On!");
  });

// 소켓서버와 웹서버 설정 및 실행
var io = socketio.listen(server);

// connection
io.sockets.on("connection", function (socket) {
  console.log("client 연결 요청 성공");

  socket.on("rint", function (data) {
    // 클라이언트가 전송한 데이터 처리
    console.log("Client Send Data : " + data);
    socket.emit("smart", data);
  });

  // disconnection
  socket.on("disconnect", function () {
    console.log("client 정보: ", socket.id, " client disconnect");
  });
});

// public : 나를 포함한 모든 소켓, broadcast: 나를 제외한 모든 소켓, private : 특정 사용자
