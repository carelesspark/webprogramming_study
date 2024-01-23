var url = require("url");

var parseObject = url.parse("https://www.naver.com");

// console.log(parseObject);

console.log(parseObject.protocol);
console.log(parseObject.host);