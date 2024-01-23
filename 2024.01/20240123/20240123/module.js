exports.abs = function(number){
    if(number > 0){
        return number;
    } else{
        return -number;
    }
}

exports.circle = function(radius){
    return radius * radius * Math.PI;
}