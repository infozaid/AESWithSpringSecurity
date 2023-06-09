package com.example.aeswithspringsecurity.repository;

import java.util.Optional;

import com.example.aeswithspringsecurity.enumrole.ERole;
import com.example.aeswithspringsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
