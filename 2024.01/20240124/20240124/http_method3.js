var http = require("http");
var fs = require("fs");
var qs = require("querystring");

http
  .createServer(function (req, res) {
    if (req.method == "GET") {
      fs.readFile("HTMLPage.html", function (error, data) {
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(data);
      });
    } else if (req.method == "POST") {
      var body = "";
      req.on("data", function (data) {
        console.log(data);
        body = body + data;
        var post = qs.parse(body);
        var dataA = post.data_a;
        var dataB = post.data_b;
        console.log("data_a : " + dataA);
        console.log("data_b : " + dataB);
        res.writeHead(200, { "Content-Type": "text/html" });
        res.end(`<!DOCTYPE html>
            <html lang="en">
              <head>
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <title>HtmlPage-POST</title>
              </head>
              <body>
                <p>data1: ${dataA}</p>
                <p>data2: ${dataB}</p>
              </body>
            </html>
            `);
      });
    }
  })
  .listen(8080, function () {
    console.log("Server On");
  });
