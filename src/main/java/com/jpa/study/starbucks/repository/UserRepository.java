package com.jpa.study.starbucks.repository;

import com.jpa.study.starbucks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
