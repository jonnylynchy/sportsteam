package com.java3.service;

/**
 * Created by jon.lynch on 6/24/17.
 */
import com.java3.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
