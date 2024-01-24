var http = require('http');

http.createServer(function(req, res){
    if(req.method == 'GET'){
        console.log('Get요청');
    } else if(req.method == 'POST'){
        console.log('POST요청');
    }
}).listen(8080, function(){
    console.log('Server On');
})