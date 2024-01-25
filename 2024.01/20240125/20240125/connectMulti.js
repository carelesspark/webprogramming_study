var express = require('express');
var multipart = require('connect-multiparty');
var fs = require('fs');

var app = express();

app.use(multipart({uploadDir : __dirname + '/multipart'}));

app.get('/', function(req, res){
    fs.readFile('fileUpload.html', function(error, data){
        res.send(data.toString());
    });
});

app.post('/', function(req, res){
    console.log(req.body);
    console.log(req.files);
    console.log(req.files.image.type);
});

app.listen(8080, function(){
    console.log('Server On');
})