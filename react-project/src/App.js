import React from 'react';
import UserComponent  from "./component/UserComponent";
import LoginUserComponent  from "./component/LoginUserComponent";
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";

function App() {
  return (    
      <div className="container">
         <UserComponent/>
      </div>  
  );
}

export default App;