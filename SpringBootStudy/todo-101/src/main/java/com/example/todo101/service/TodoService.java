package com.example.todo101.service;

import java.util.List;
import java.util.Optional;

import com.example.todo101.model.TodoEntity;
import com.example.todo101.persistence.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

  @Autowired
  TodoRepository todoRepository;

  public List<TodoEntity> create(TodoEntity entity) {
    validate(entity);
    todoRepository.save(entity);
    log.info("Entity Id : {} is saved.", entity.getId());
    return todoRepository.findByUserId(entity.getUserId());
  }

  public List<TodoEntity> retrieve(String userId) {
    return todoRepository.findByUserId(userId);
  }

  public List<TodoEntity> update(TodoEntity entity) {
    validate(entity);
    Optional<TodoEntity> original = todoRepository.findById(entity.getId());
    original.ifPresent(todo -> {
      todo.setTitle(entity.getTitle());
      todo.setDone(entity.isDone());
      todoRepository.save(todo);
      log.info("Entity Id : {} is updated.", entity.getId());
    });
    return retrieve(entity.getUserId());
  }

  public List<TodoEntity> delete(TodoEntity entity) {
    validate(entity);
    try {
      todoRepository.delete(entity);
    } catch (Exception e) {
      log.error("error deleting entity ", entity.getId(), e);
      throw new RuntimeException("error deleting entity " + entity.getId());
    }
    return retrieve(entity.getUserId());
  }

  private void validate(TodoEntity entity) {
    if (entity == null) {
      log.warn("Entity cannot be null.");
      throw new RuntimeException("Entity cannot be null.");
    }
    if (entity.getUserId() == null) {
      log.warn("Unknown user.");
      throw new RuntimeException("Unknown user.");
    }
  }
}
