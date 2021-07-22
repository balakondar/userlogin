import React, { Component } from "react";
import axios from 'axios';
import { withRouter } from "react-router-dom";

class Login extends Component {
  constructor(props){
    super(props);
    this.state={
        users:[],
        userId:0,
        firstName:'',
        lastName:'',
        email:'',
        password:''
    }    
}
submit(event){
  event.preventDefault();
  console.log('Delete User Id :');
  const userLoginRequest ={
    email:this.state.email,
    password:this.state.password
  } 
  //setError(null);
  //setLoading(true);
        axios.post('http://localhost:8080/User/Login',userLoginRequest).then((res) => {
         // setLoading(false);  
            console.log('User Login Response :'+res.data.userId);            
            this.props.history.push('/home')
            
         }).catch(error =>{
         // setLoading(false); 
         console.error('error1331 >>>',error);
          if(error.status===401 && error.status===400){
          console.error('error >>>',error.response.status);
          }         

         })
  }
  

  render() {
    return (
      <div className="container">
      <div className="row">
      <div className="col 6"></div>
      <form onSubmit={(e)=>this.submit(e)}>
      <div class="input-field col s12">
                <i class="material-icons prefix">email</i>
                <input onChange={(e)=>this.setState({email:e.target.value})} value={this.state.email} type="email" id="autocomplete-input" class="autocomplete" />
                <label for="autocomplete-input">Enter Email</label>
            </div>
            <div class="input-field col s12">
                <i class="material-icons prefix">vpn_key</i>
                <input onChange={(e)=>this.setState({password:e.target.value})} value={this.state.password} type="password" id="autocomplete-input" class="autocomplete" />
                <label for="autocomplete-input">Enter Password</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
            <i class="material-icons right">send</i>
            </button>
            </form>
         <div className="col 6"></div>
         </div>
         </div>
    );
  }
}

export default Login;