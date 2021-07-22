import axios from 'axios';

const FETCH_USERS = 'http://localhost:8080/User/FetchUser';
const CREATE_USER = 'http://localhost:8080/User/CreateUser';
const UPDATE_USERS = 'http://localhost:8080/User/UpdateUser';
const DELETE_USERS = 'http://localhost:8080/User/DeleteUser';

class UserServices {

    fetchUsers() {
        console.log('In fetchUsers service')
        return axios.get(FETCH_USERS);
    }
    createUser() {
        console.log('In createUser service')
        return axios.post(CREATE_USER);
    }
    UpdateUser() {
        console.log('In UpdateUser service')
        return axios.get(UPDATE_USERS);
    }
    deleteUser() {
        console.log('In deleteUser service')
        return axios.get(DELETE_USERS);
    }
}

export default new UserServices();