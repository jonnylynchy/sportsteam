package com.java3.repository;

/**
 * Created by jon.lynch on 6/24/17.
 */
import com.java3.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java3.model.User;

import java.util.List;

@Repository("userRepositoryMain")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findUsersByTeams(Team team);
}