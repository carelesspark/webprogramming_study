var rint = require('./rint');

rint.timer.on('park', function(){
    console.log('이벤트 실행 중!');
});