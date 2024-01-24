var http = require('http');
var url = require('url');

http.createServer(function(req, res){
    var query = url.parse(req.url, true).query; // true : 쿼리스트링 정보를 객체 형태로 반환, false : 쿼리스트링 정보를 문자열 형태로 변환
    console.log(query);

    res.writeHead(200, {'Content-Type' : 'text/html'});
    res.end('<h1>' + JSON.stringify(query) + '</h1>');
}).listen(8080, function(){
    console.log('Server On');
})