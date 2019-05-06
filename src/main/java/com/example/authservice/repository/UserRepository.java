package com.example.authservice.repository;

import com.example.authservice.model.AuthenticationServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AuthenticationServiceUser, Long> {

    Optional<AuthenticationServiceUser> findByUsername(String username);
}
