package com.emmabraboke.User;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private UserService userService;

    public User(String id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
