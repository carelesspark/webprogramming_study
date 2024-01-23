var EventEmitter = require('events');

exports.timer = new EventEmitter();

setInterval(function(){
    exports.timer.emit('park');
}, 1000);