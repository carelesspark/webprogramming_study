var express = require('express');
var ejs = require('ejs');
var bodyParser =require('body-parser');
var fs =require('fs');
var mysql = require('mysql2');
require('dotenv').config();

var app = express();

var client = mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_DATABASE,
    port: process.env.DB_PORT,
});

app.use(bodyParser.urlencoded({extended:false}));

app.listen(8080,function(){
    console.log("Server Running at http://127.0.0.1:52273");

})

app.get('/',function(req,res){
    fs.readFile('list.html','utf-8',function(error,data){
            client.query('select * from products', function(error, results){
                res.send(ejs.render(
                    data,
                    {data:results}
                )); 
            });
    });
});

app.get('/delete/:id',function(req,res){
    client.query('delete from products where id=?',
    [req.params.id],function(error, results){
        res.redirect('/');
    })
});

app.get('/insert',function(req,res){
    fs.readFile('insert.html','utf-8',function(error,data){
        res.send(data);
    });
});

app.post('/insert',function(req,res){
    var body = req.body;

    client.query('insert into products (name, modelnumber, series) values(?,?,?)',
    [body.name, body.modelnumber, body.series],function(){
        res.redirect('/');
    })
});

app.get('/edit/:id',function(req,res){
    fs.readFile('edit.html','utf-8',function(error,data){
        client.query('select * from products where id = ?', 
        [req.params.id],function(error, results){
            res.send(ejs.render(
                data,
                {data:results}
            )); 
        });
    });
});

app.post('/edit/:id',function(req,res){
    var body = req.body;

    client.query('update products set name=?, modelnumber=?, series=? where id=?',
    [body.name, body.modelnumber, body.series, req.params.id],function(){
        res.redirect('/edit/'+req.params.id);
    })
});