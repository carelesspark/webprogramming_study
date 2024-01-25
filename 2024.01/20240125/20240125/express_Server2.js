var express = require('express');

var app = express();

app.use(function(req, res, next){
    console.log('첫 번째 미들웨어');
    next();
});
app.use(function(req, res, next){
    console.log('두 번째 미들웨어');
    next();
});
app.use(function(req, res, next){
    console.log('세 번째 미들웨어');
    res.writeHead(200, {'Content-Type' : 'text/html'});
    res.end('<h1> Hello World!</h1>')
});

app.listen(8080, function(){
    console.log('Express Server on');
});