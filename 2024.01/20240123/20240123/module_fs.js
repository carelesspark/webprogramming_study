var fs = require('fs');

var textFile = fs.readFileSync('textFile.txt', 'utf-8');
console.log(textFile);

fs.readFile('textFile.txt', 'utf-8', function(error, data) {
    console.log(data);
    if(data == null){
        console.log(error);
    }
});

var writeText = "Hello World!";

fs.writeFileSync('textFile3.txt', writeText, 'utf-8', function(error){
    console.log('새로운 Text파일이 생성되었습니다.');
});

fs.writeFileSync('textFileSync.txt', writeText, 'utf-8');
console.log('write sync complete');