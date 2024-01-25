var express = require('express');
var cookieParser = require('cookie-parser');

var app = express();

// cookie 미들웨어
app.use(cookieParser());
app.get('/getCookie', function(req, res){[
    res.send(req.cookies)
]});

app.get('/setCookie', function(req, res){
    // 쿠키 생성
    res.cookie('string', 'cookie', {maxAge:6000});
    res.cookie('json', {
        name: 'cookie',
        property: 'delicious'
    });

    res.redirect('/getCookie');
})

app.listen(8080, function(){
    console.log('Server On');
})