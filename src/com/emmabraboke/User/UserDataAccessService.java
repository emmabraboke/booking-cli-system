package com.emmabraboke.User;

import javax.naming.NameNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class UserDataAccessService implements UserDAO {
    private static User[] users = new User[0];

    public UserDataAccessService() {
    }

    public User createUser(User user){
        users = append(user, users);
        return user;
    }

    public User[] getUsers(){
        if(users.length == 0){
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
        try(FileReader fileData = new FileReader(file);) {
            Scanner readFile = new Scanner(fileData);

            while (readFile.hasNext()){
                String line =  readFile.nextLine();

                String[] item = line.split(",");

                User user = new User(item[0], item[1], item[2]);
                users = append(user, users);
            }


        }catch (Exception FileNotFoundException){
            System.out.println(FileNotFoundException.toString());
        }

    }
    public User[] append(User user, User[] users){
        User[] temp = users;
        int size = temp.length;
        users = new User[size+1];

        System.arraycopy(temp, 0, users, 0, temp.length);
        users[temp.length] = user;
        return users;
    }
}
