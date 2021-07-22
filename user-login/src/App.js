import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch, Link, NavLink } from "react-router-dom";
import Login from "./Login";
import Home from "./Home";


class App extends Component {

  render() {
    return (
      <div>     
      <Router>
        <div style={{justifyContent:'center',color:'blue'}}>  
          <NavLink activeClassName="active" to="/login">Login</NavLink>
          <NavLink activeClassName="active" to="/home">Home</NavLink>              
        <hr/>
          <Switch>            
            <Route exact path="/login" component={Login} />
            <Route exact path="/home" component={Home} />
          </Switch>
        </div>
      </Router>
      </div>
    );
  }
}

export default App;