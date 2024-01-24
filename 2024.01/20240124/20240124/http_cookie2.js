var http = require("http");

http
  .createServer(function (req, res) {
    var cookie = req.headers.cookie;

    if (cookie) {
      var cookies = req.headers.cookie.split(";").map(function (element) {
        var element = element.split("=");
        return { key: element[0], value: element[1] };
      });
      res.end("<h1>" + JSON.stringify(cookies) + "</h1>");
    } else { 
      res.writeHead(200, {
        "Content-Type": "text/html;charset=utf-8",
        "Set-Cookie": ["name = park", "region = ansan"],
      });
      res.end("<h1>쿠키가 없습니다.</h1>");
    }
  })
  .listen(8080, function () {
    console.log("Server On");
  });
