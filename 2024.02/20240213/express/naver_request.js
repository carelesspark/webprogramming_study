const morgan = require('morgan');
const express = require('express');
const request = require('request');

const app = express();

app.set('port', process.env.PORT || 8080);

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({extended: true}));

var client_id = 'key_id';
var client_secret = 'key_password';
app.get('/naver/news', (req, res) => {
    var api_url = 'https://openapi.naver.com/v1/search/news?query=' + encodeURI(req.query.query); // JSON 결과

   const option = {
    
   };

   var options = {
       url: api_url,
       qs: option,
       headers: {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret': client_secret}
    };
   request.get(options, function (error, response, body) {
     if (!error && response.statusCode == 200) {
       res.writeHead(200, {'Content-Type': 'text/json;charset=utf-8'});
       res.end(body);
     } else {
       res.status(response.statusCode).end();
       console.log('error = ' + response.statusCode);
     }
   });
});

app.listen(app.get('port'), () => {
    console.log('Server On');
});