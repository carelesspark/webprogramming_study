import React, {Component} from "react"
import $ from 'jquery';

class R_Jquery extends Component {
    
    input_alert = (e) => {
        var input_val = $('#inputId').val();
        alert(input_val);
    };

    render(){
        return(
            <div>
                <h2>[ THIS IS IMPORTED COMPONENT ]</h2>
                <input id="inputId" name="inputName" />
                <button id="buttonId" onClick={e => this.input_alert(e)}>Jquery Button</button> 
            </div>
        )
    }
}

export default R_Jquery;