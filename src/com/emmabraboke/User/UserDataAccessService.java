package com.emmabraboke.User;

import javax.naming.NameNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class UserDataAccessService implements UserDAO {
    private static List<User> users = new ArrayList<>();

    public UserDataAccessService() {
    }

    public User createUser(User user){
        users.add(user);
        return user;
    }

    public List<User> getUsers(){
        if(users.isEmpty()){
            System.out.println("no users found");
        }
        return users;
    }

    public  User getUser(String id){
        for( User user: users ){
            if(user !=null && user.getId().equals(id)){
              return user;
            }
        }
        System.out.println("no user found");

        return null;
    }

    public void users(String path){
        File file = new File(path);
        try(BufferedReader fileData = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = fileData.readLine()) != null){

                String[] item = line.split(",");

                User user = new User(item[0], item[1], item[2]);
                users.add(user);
            }


        }catch (Exception FileNotFoundException){
            System.out.println(FileNotFoundException.toString());
        }

    }
}
