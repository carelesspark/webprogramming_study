var express = require('express');

var app = express();

app.get('/page/:id', function(req, res){
    var page = req.params.id;

    res.send('<h1>' + page + 'Page</h1>');
});

app.listen(8080, function(){
    console.log('Server On');
});