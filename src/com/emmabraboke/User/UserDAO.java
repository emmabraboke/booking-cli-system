package com.emmabraboke.User;

public interface UserDAO {
    User createUser(User user);
    User[] getUsers();
    User getUser(String id);

    User[] append(User user, User[] users);

    void users(String path);
}
