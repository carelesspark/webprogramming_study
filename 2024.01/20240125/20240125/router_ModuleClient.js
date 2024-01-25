var express = require('express');
var expressRouterA = require('./router_ModuleMainA').router;
var expressRouterB = require('./router_ModuleMainB').router;
var expressRouterC = require('./router_ModuleMainC').router;

var app = express();

app.use('/a', expressRouterA);
app.use('/b', expressRouterB);
app.use('/c', expressRouterC);


app.listen(8080, function(){
    console.log('Server On');
})