var express = require('express');
var morgan = require('morgan');

var app = express();

// static 미들웨어 
app.use(express.static(__dirname + '/public'));

// morgan 미들웨어
app.use(morgan('combined'));
app.use(morgan(':method + :date'));


app.use(function(req, res){
    res.writeHead(200, {'Content-Type' : 'text/html'});
    res.end('<img src="/naver.png" width="50%" height="50%">');
});

app.listen(8080, function(){
    console.log('Server On');
});