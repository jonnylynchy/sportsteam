package com.java3.repository;

/**
 * Created by jon.lynch on 6/24/17.
 *
 * JPA Repository Interface for Role
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java3.model.Role;

@Repository("roleRepositoryMain")
public interface RoleRepository extends JpaRepository<Role, Integer>{

    // Custom to find a role by its string label
    Role findByRole(String role);
}