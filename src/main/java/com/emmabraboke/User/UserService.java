package com.emmabraboke.User;

import java.util.List;

public class UserService {

    private final UserDataAccessService userDataAccessService;

    public UserService(UserDataAccessService userDataAccessService) {
        this.userDataAccessService = userDataAccessService;
    }

    public User createUser(User user){
       return userDataAccessService.createUser(user);
    }

    public List<User> getUsers(){
        return userDataAccessService.getUsers();

    }

    public User getUser(String id){
        return userDataAccessService.getUser(id);

    }

    public void viewAllUsers(){
        printUsers();
    }

    public void printUsers(){
        List<User> users = this.getUsers();
        for(User user: users){
            System.out.println(user);
        }
    }
}
