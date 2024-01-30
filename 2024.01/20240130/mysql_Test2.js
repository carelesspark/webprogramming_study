var mysql = require("mysql2");
require("dotenv").config();

var client = mysql.createConnection({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_DATABASE,
  port: process.env.DB_PORT,
});

//client.query('USE Company');
// client.query('select * from products', function(error, result, fields){
//     if(error){
//         console.log('쿼리문 실행 오류 발생');
//     } else {
//         console.log(result);
//     }
// });

client.query(
  "insert into products(name, modelnumber, series) values (?, ?, ?)",
  ["Test Name", "Test Model", "Test series"],
  function (error, result, fields) {
    if (error) {
      console.log("쿼리문 실행 오류 발생");
    } else {
      console.log(result);
    }
  }
);
