var EventEmitter = require('events');
var custom = new EventEmitter();
// 사용자 정의 이벤트

custom.on('park', function(){
    console.log('사용자 정의 이벤트 생성');
});

custom.emit('park'); 