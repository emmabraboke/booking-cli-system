package com.emmabraboke.User;

import java.util.List;

public interface UserDAO {
    User createUser(User user);
    List<User> getUsers();
    User getUser(String id);
}
