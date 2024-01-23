process.on('exit', function(){
    console.log('Bye.....');
});

process.exit(); // 이벤트 강제 종료

process.emit('exit'); // 이벤트 리스너 여러 번 호출
process.emit('exit');
process.emit('exit');
process.emit('exit');

console.log('Program Exit');