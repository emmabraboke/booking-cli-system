package com.emmabraboke.User;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDAO{
private final UserDataAccessService userDataAccessService;
    public  UserFakerDataAccessService(Faker faker, UserDataAccessService userDataAccessService, List<User> users) {

        this.userDataAccessService = userDataAccessService;
        for(User user: users) {
            System.out.println(user);
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();

            user.setId(UUID.randomUUID().toString());
            user.setFirstName(firstName);
            user.setLastName(lastName);

            createUser(user);
        }
    }


    @Override
    public User createUser(User user) {
        userDataAccessService.createUser(user);
        return user;
    }

    public List<User>  getUsers(){
        return userDataAccessService.getUsers();
    }

    @Override
    public User getUser(String id) {
        List<User> users = userDataAccessService.getUsers();
        for( User user: users ){
            if(user !=null && user.getId().equals(id)){
                return user;
            }
        }
        System.out.println("no user found");

        return null;
    }
    
}
