var mysql = require('mysql2');
require('dotenv').config();
const env = process.env;

var client = mysql.createConnection({
    host: env.DB_HOST,
    user: env.DB_USER,
    password: env.DB_PASSWORD,
    database: env.DB_DATABASE
});

//client.query('USE Company');
client.query('select * from products', function(error, result, fields){
    if(error){
        console.log('쿼리문 실행 오류 발생');
    } else {
        console.log(result);
    }
});

