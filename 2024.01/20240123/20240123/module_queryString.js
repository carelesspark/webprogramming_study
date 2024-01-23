var url = require('url');
var queryString = require('querystring');

var parseObject = url.parse('https://entertain.naver.com/read?oid=241&aid=0003325927');
var quers = queryString.parse(parseObject.query);


console.log(queryString.parse(parseObject.query));  // 객체 형식
console.log(parseObject.search);    // String 형식
console.log(quers.oid, quers.aid);  // key 값 형식