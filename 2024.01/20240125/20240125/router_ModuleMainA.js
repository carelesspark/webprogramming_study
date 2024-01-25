var express = require('express');
var router = express.Router();

router.get('/index', function(req, res){
    res.send('<h1>Router Module : A</h1><a href="/b/index">go to B</a> <br> <a href="/c/index">go to C</a>');
});

exports.router = router;