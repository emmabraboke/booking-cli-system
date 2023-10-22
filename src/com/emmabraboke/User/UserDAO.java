package com.emmabraboke.User;

import java.util.Arrays;
import java.util.UUID;

public class UserDAO {
    private static User[] users = new User[0];


    public static User createUser(User user){
        String id = UUID.randomUUID().toString();
        user.setId(id);

        users = append(user, users);
        return user;
    }

    public static User[] getUsers(){
        if(users.length == 0){
            System.out.println("no users found");
        }
        return users;
    }

    public static User getUser(String id){
        for( User user: users ){
            if(user !=null && user.getId().equals(id)){
              return user;
            }
        }
        System.out.println("no user found");

        return null;
    }

    static User[] append(User user, User[] users){
        User[] temp = users;
        int size = temp.length;
        users = new User[size+1];

        System.arraycopy(temp, 0, users, 0, temp.length);
        users[temp.length] = user;

        return users;
    }
}
