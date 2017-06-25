package com.java3.service;

/**
 * Created by jon.lynch on 6/24/17.
 */
import com.java3.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
