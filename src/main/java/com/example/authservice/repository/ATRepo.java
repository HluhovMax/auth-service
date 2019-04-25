package com.example.authservice.repository;

import com.example.authservice.model.AT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ATRepo extends JpaRepository<AT, Long> {
}
