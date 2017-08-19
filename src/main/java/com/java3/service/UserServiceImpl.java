package com.java3.service;

/**
 * Created by jon.lynch on 6/24/17.
 *
 * Implementation of UserService
 */
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java3.model.Role;
import com.java3.model.User;
import com.java3.repository.RoleRepository;
import com.java3.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

    // Necessary Repositories

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // Password Encoder
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Implementation to find a User by their email
     * @param email
     * @return
     */
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Save User
     * Sets them as active and encrypts the password
     * @param user
     */
    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}
