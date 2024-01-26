var express = require('express');
var session = require('express-session');

var app = express();

// 세션 미들웨어 설정
app.use(session({
    secret: 'secret key',   // 세션 이름
    resave: false,  
    // true : 값이 바뀌던 안바뀌던 계속 값을 저장한다.
    // false : 세션데이터가 바뀌기 전까지는 세션 저장소의 값을 저장하지 않는다.
    
    saveUninitialized: true,
    // true : 세션이 필요하기 전까지는 세션을 구동시키지 않는다.

    cookie: {maxAge: 60 * 1000}
}));

app.use(function(req, res){
    req.session.now = (new Date()).toUTCString();
    res.send(req.session);
})

app.listen(8080, function(){
    console.log('Server On');
})