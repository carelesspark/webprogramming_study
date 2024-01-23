process.on('exit', function(code){
    console.log('Bye...');
});

process.on('uncaughtException', function(error){
    console.log('예외 발생...'); 
});

// 2초 간격으로 3번 예외
var count = 0;

var test = function(){
    count = count + 1;
    if(count > 3){
        return;
    }

    setTimeout(test, 2000); // 재귀 호출
    error.error.error(); // 강제 예외 발생(자바의 throws와 비슷한 기능)

}
setTimeout(test, 2000);