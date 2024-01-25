var express = require('express');
var router = express.Router();

router.get('/index', function(req, res){
    res.send('<h1>Router Module : B</h1><a href="/a/index">go to A</a> <br> <a href="/c/index">go to C</a>');
});

exports.router = router;