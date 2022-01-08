package com.example.todo101.service;

import com.example.todo101.model.TestEntity;
import com.example.todo101.persistence.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  TestRepository testRepository;

  public String testService() {
    return "touch Service";
  }

  public String testPersistence() {
    TestEntity entity = TestEntity.builder().name("temp").message("touch Persistence").build();
    testRepository.save(entity);
    TestEntity savedEntity = testRepository.findById(entity.getId()).get();
    return savedEntity.getMessage();
  }
}
