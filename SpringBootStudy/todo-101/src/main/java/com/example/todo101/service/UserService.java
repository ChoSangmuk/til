package com.example.todo101.service;

import com.example.todo101.model.UserEntity;
import com.example.todo101.persistence.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public UserEntity create(UserEntity entity) {
    if (entity == null || entity.getEmail() == null) {
      throw new RuntimeException("Invalid arguments");
    }
    String email = entity.getEmail();
    if (repository.existsByEmail(email)) {
      log.warn("Email already exists {}", email);
      throw new RuntimeException("Email already exists");
    }
    return repository.save(entity);
  }

  public UserEntity getByCredentials(String email, String password, PasswordEncoder encoder) {
    UserEntity entity = repository.findByEmail(email);

    if (entity != null && encoder.matches(password, entity.getPassword())) return entity;
    return null;
  }
}
