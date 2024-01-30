var express = require("express");
var ejs = require("ejs");
var mysql = require("mysql2");
var bodyParser = require("body-parser");
var fs = require("fs");
require('dotenv').config();

var app = express();

var client = mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_DATABASE,
    port: process.env.DB_PORT,
  });

app.use(
  bodyParser.urlencoded({
    extended: false,
  })
);

// 전체 목록 조회
app.get("/", function (req, res) {
  fs.readFile("list.html", "utf-8", function (error, data) {
    client.query("select * from products", function (error, results) {
        res.send(ejs.render(data, {data: results}));
    });
  });
});

// 데이터 삭제
app.get("/delete/:id", function (req, res) {
    client.query('delete from products where id = ?', [req.params.id], function(){
        res.redirect('/');
    });
});

// 데이터 삽입 화면 요청
app.get("/insert", function (req, res) {
    fs.readFile('insert.html', 'utf-8', function(error, data){
        res.send(data);
    });
});

// 데이터 삽입 처리
app.post("/insert", function (req, res) {

});

// 데이터 수정 화면 요청
app.get("/edit/:id", function (req, res) {});

// 데이터 수정 처리
app.post("/edit/:id", function (req, res) {});

app.listen(8080, function () {
  console.log("Server On");
});
