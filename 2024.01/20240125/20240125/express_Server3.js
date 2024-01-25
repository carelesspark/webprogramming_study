var express = require('express');

var app = express();

app.use(function (req, res, next){
    req.number = 32;
    res.number = 12;
    next();
});
app.use(function (req, res, next){
   res.send('<h1>' + req.number + ':' + res.number + '<h1>');
});

app.listen(8080, function(){
    console.log('Server On');
});