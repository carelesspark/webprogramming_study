var express = require('express');

var app = express();

app.get('/a', function(req, res){
    res.send('<a href="/b">Go to B</a>');
})
app.get('/b', function(req, res){
    res.send('<a href="/a">Go to A</a>');
});

app.listen(8080, function(){
    console.log('Server On');
});