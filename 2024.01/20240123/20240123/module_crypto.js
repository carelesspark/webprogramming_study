var crypto = require('crypto');

var key = '비밀번호 값';
var input = 'PASSWORD';

var cipher = crypto.createCipher('aes192', key);
cipher.update(input, 'utf-8', 'base64');
var cipheredOutput = cipher.final('base64');

console.log(input); // 기존 패스워드
console.log(cipheredOutput);    // 암호화된 패스워드

var decipher = crypto.createDecipher('aes192', key);
decipher.update(cipheredOutput, 'base64', 'utf-8');
var decipheredOutput = decipher.final('utf-8');

console.log(cipheredOutput);
console.log(decipheredOutput);