import React, { Component } from "react";

class SpreadOperator extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  componentDidMount() {
    //Array
    let varArray1 = ["num1", "num2"];
    let varArray2 = ["num3", "num4"];
    let sumVarArr = [varArray1[0], varArray1[1], varArray2[0], varArray2[1]];

    console.log(sumVarArr);

    let sumLetArr = [...varArray1, ...varArray2];

    console.log(sumLetArr);

    const [sum1, sum2, ...remain] = sumLetArr; // const 변수명 = 값;

    console.log("sum1=" + sum1);
    console.log("sum2=" + sum2);
    console.log("remain=" + remain);

    let varObj1 = { key1: "val1", key2: "val2" };
    var varObj2 = { key2: "new2", key3: "val3" };

    let sumVarObj = Object.assign({}, varObj1, varObj2);
    console.log("sumVarObj =" + JSON.stringify(sumVarObj));

    let sumLetObj = { ...varObj1, ...varObj2 };
    console.log("sumLetObj =" + JSON.stringify(sumLetObj));
    let { key1, key3, ...others } = sumLetObj;
    console.log("key1=" + key1);
    console.log("key3=" + key3);
    console.log("others=" + JSON.stringify(others));
  }

  render() {
    return <h2>[ THIS IS IMPORTED COMPONENT ]</h2>;
  }
}

export default SpreadOperator;
