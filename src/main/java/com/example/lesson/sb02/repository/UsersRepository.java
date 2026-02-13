package com.example.lesson.sb02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson.sb02.entity.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    // Spring Data JPA 自動實作
}
