var express = require('express');
var router = express.Router();

router.get('/index', function(req, res){
    res.send('<h1>Router Module : C</h1><a href="/b/index">go to B</a> <br> <a href="/a/index">go to A</a>');
});

exports.router = router;