import React, { Component } from "react";

class Home extends Component {
state={}
  render() {
    return (
      <div>
        <div></div>
       <iframe
       id="fr"
       name="myframe"
       width="900"
       height="600"
       src="http://localhost:4000/"
       allow=""       
       ></iframe>
      </div>
    );
  }
}

export default Home;