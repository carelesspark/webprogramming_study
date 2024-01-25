var express = require('express');

var app = express();

var routerA = express.Router();
var routerB = express.Router();

routerA.get('/index', function(req, res){
    res.send('<h1>Index Page Router A</h1>');
});

routerB.get('/index', function(req, res){
    res.send('<h1>Index Page Router B</h1>');
});

app.use('/a', routerA);
app.use('/b', routerB);

app.listen(8080, function(){
    console.log('Server On');
})