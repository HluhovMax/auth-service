package com.example.authservice.repository;

import com.example.authservice.model.RT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTRepo extends JpaRepository<RT, Long> {
}
