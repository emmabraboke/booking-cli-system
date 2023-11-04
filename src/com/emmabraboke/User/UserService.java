package com.emmabraboke.User;

public class UserService {

    private final UserDataAccessService userDataAccessService;

    public UserService(UserDataAccessService userDataAccessService) {
        this.userDataAccessService = userDataAccessService;
    }

    public User createUser(User user){
       return userDataAccessService.createUser(user);
    }

    public  User[] getUsers(){
        User[] users =  userDataAccessService.getUsers();

        if(users.length == 0){
            System.out.println("no users");
        }

        return users;
    }

    public User getUser(String id){
        return userDataAccessService.getUser(id);

    }

    public void viewAllUsers(UserService userSrv){
        userSrv.printUsers();
    }

    public void printUsers(){
        User[] users = this.getUsers();
        for(User user: users){
            System.out.println(user);
        }
    }
}
