import React, { Component } from "react";

// 1. 화살표 함수는 this를 가지지 않습니다.
// 2. 화살표 함수에는 argumetns가 없습니다.
// 3. 화살표 함수는 new와 함께 호출할 수 없습니다.
// 4. 화살표 함수에는 super 없습니다.
// function add(var x) { return x; } (x) ==>{x};

class ArrowFunction extends Component {
  constructor(props) {
    super(props);
    this.state = {
      arrowFuc: "React200",
      num: 3,
    };
  }

  componentDidMount() {
    Function1(1);
    this.Function2(1, 2);
    this.Function3();
    this.Function4();
    this.Function5(1, 2, 3);
    function Function1(num1) {
      return console.log(num1 + "1. ES5 function");
    }
  }

  Function2 = (num1, num2) => {
    let num3 = num1 + num2;
    console.log(num3 + "2. Arrow Function :", this.state.arrowFuc);
  };

  Function3() {
    var this_bind = this;   // 컴퍼넌트의 this를 값으로 저장
    setTimeout(function(){  // 콜백함수는 컴퍼넌트의 this에 접속불가
        console.log(this_bind.state.arrowFuc + '3. Es5 Callback Function noBind : ');
    }, 100);
  }

  Function4(){
    setTimeout(function(){  // 콜백함수는 컴퍼넌트의 this에 접속불가
        console.log(this.state.arrowFuc + '4. Es5 Callback Function noBind : '); // tihs => window의 this, 만약 뒤에 .bind(this)를 하게 되면 클래스의 this로 변경 됌
    }.bind(this), 100); 
  }

  Function5 = (num1, num2, num3) => {
    const num4 = num1 + num2 + num3;
    setTimeout(() => {
        console.log(this.state.arrowFuc + '5. Arrow Callback Function' + num4); // 위와 다르게 화살표함수를 사용할 경우 .bind(this)가 없음에도, this => 클래스의 this임
    }, 100);
  }

  render() {
    return <h2>[THIS IS IMPORTED Component]</h2>;
  }
}

export default ArrowFunction;
