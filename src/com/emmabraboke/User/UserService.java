package com.emmabraboke.User;

public class UserService {

    public User createUser(User user){
       return UserDAO.createUser(user);
    }

    public  User[] getUsers(){
        User[] users =  UserDAO.getUsers();

        if(users.length == 0){
            System.out.println("no users");
        }

        return users;
    }

    public User getUser(String id){
        return UserDAO.getUser(id);

    }

    public void printUsers(){
        User[] users = this.getUsers();
        for(User user: users){
            System.out.println(user);
        }
    }
}
