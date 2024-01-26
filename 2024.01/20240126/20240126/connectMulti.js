var express = require('express');
var multipart = require('connect-multiparty');
var fs = require('fs');

var app = express();

app.use(multipart({uploadDir:__dirname + '/multipart'}));

app.get('/', function (req, res) {
      fs.readFile('fileUpload.html', function (error, data) {
        res.send(data.toString()); 
      }); 
});

app.post('/',function (req, res) {
        // console.log(req.body);
        // console.log(req.files);
        // console.log(req.files.image.type);

        var comment = req.body.comment;
        var imageFile = req.files.image;

        if(imageFile){
              var name = imageFile.name;
              var path = imageFile.path;
              var type = imageFile.type; 
              
              if(type.indexOf('image') != -1){
                var outputPath = __dirname + '/multipart/' + Date.now() + '_' + name;
                fs.rename(path,outputPath,function(error){
                        res.redirect('/');
                });
              }else{
                fs.unlink(path,function(error){
                        req.sendStatus(400);
                });
              }
        }else{
                res.sendStatus(404);
        }
});

app.listen(8080, function(){
        console.log('Server On');
});