package com.example.todo101.persistence;

import com.example.todo101.model.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
  UserEntity findByEmail(String email);

  boolean existsByEmail(String email);

  UserEntity findByEmailAndPassword(String email, String password);
}
