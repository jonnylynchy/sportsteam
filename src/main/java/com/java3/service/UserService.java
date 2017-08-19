package com.java3.service;

/**
 * Created by jon.lynch on 6/24/17.
 *
 * Service Interface for User
 */
import com.java3.model.User;

public interface UserService {

    // Custom method to find User by their email
    User findUserByEmail(String email);

    // Custom method to save user
    void saveUser(User user);
}
