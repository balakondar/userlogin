import React from 'react';
import userServices from '../services/UserServices';
import axios from 'axios';

class UserComponent extends React.Component {

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

    componentDidMount(){
        userServices.fetchUsers().then((res) => {
            this.setState({
                 users: res.data,
                 userId:'',
                 firstName:'',
                 lastName:'',
                 email:'',
                 password:''
                })
        });
    }

    submit(event,id){
        event.preventDefault();
        if(id==0){
            userServices.createUser().then((res) => {
                this.componentDidMount();

             })
        } else {
            userServices.UpdateUser().then((res) => {
                this.componentDidMount();

             })
        }

    }
    delete(userId){
        console.log('Delete User Id :'+userId);
        axios.delete('http://localhost:8080/User/DeleteUser/'+userId).then((res) => {
            this.componentDidMount();
         })
    }
    edit(id){
        userServices.fetchUsers().then((res) => {
            console.log('Edit User :'+res.data);
           this.setState( {userId:res.data.userId,
            firstName:res.data.firstName,
            lastName:res.data.lastName,
            email:res.data.email,
            password:this.res.password
           })
         })
    }

    render(){
        return (
            <div className="container">
            <div className="row">
            <div className="col 6"></div>
            <form onSubmit={(e)=>this.submit(e,this.state.userId)}>
            <div class="input-field col s12">
                <i class="material-icons prefix">person</i>
                <input onChange={(e)=>this.setState({firstName:e.target.value})} value={this.state.firstName} type="text" id="autocomplete-input" class="autocomplete" />
                <label for="autocomplete-input">Autocomplete</label>
            </div>
            <div class="input-field col s12">
                <i class="material-icons prefix">person</i>
                <input onChange={(e)=>this.setState({lastName:e.target.value})} value={this.state.lastName} type="text" id="autocomplete-input" class="autocomplete" />
                <label for="autocomplete-input">Autocomplete</label>
            </div>
            <div class="input-field col s12">
                <i class="material-icons prefix">email</i>
                <input onChange={(e)=>this.setState({email:e.target.value})} value={this.state.email} type="email" id="autocomplete-input" class="autocomplete" />
                <label for="autocomplete-input">Autocomplete</label>
            </div>
            <div class="input-field col s12">
                <i class="material-icons prefix">vpn_key</i>
                <input onChange={(e)=>this.setState({password:e.target.value})} value={this.state.password} type="password" id="autocomplete-input" class="autocomplete" />
                <label for="autocomplete-input">Autocomplete</label>
            </div>
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
            <i class="material-icons right">send</i>
            </button>
            </form>
         <div className="col 6">
        <table>
        <thead>
          <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>Role(s)</th>
              <th>Password</th>              
              <th>Edit</th>
              <th>Delete</th>
          </tr>
        </thead>

        <tbody>
                        {
                            this.state.users.map(
                                usr => 
                                <tr key = {usr.userId}>
                                     <td> {usr.firstName}</td>   
                                     <td> {usr.lastName}</td>  
                                     <td> {usr.email}</td>  
                                     <div>
                                        {usr.roles.map((role) => (
                                        <p key={role.roleId}>
                                       <td> {role.roleName} </td>  
                                        </p>
                                        ))}
                                    </div>  
                                    <td> {usr.password}</td>                                  
                                     <td>
                                         <button onClick={(e)=>this.edit(usr.userId)}  class="btn waves-effect waves-light" type="submit" name="action">
                                        <i class="material-icons">edit</i>
                                        </button> 
                                    </td> 
                                    <td>
                                         <button onClick={(e)=>this.delete(usr.userId)} class="btn waves-effect waves-light" type="submit" name="action">
                                        <i class="material-icons">delete</i>
                                        </button> 
                                    </td> 
                                </tr>
                            )
                        }

                    </tbody>
      </table>
     </div>
                </div>
            </div>
        )
    }

}

export default UserComponent;