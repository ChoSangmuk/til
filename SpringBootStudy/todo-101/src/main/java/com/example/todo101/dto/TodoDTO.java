package com.example.todo101.dto;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.example.todo101.model.TodoEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
  private String id;
  private String title;
  private boolean done;

  public TodoDTO(TodoEntity todoEntity) {
    this.id = todoEntity.getId();
    this.title = todoEntity.getTitle();
    this.done = todoEntity.isDone();
  }

  public static TodoEntity toEntity(TodoDTO todoDTO) {
    return TodoEntity.builder()
        .id(todoDTO.getId())
        .title(todoDTO.getTitle())
        .done(todoDTO.isDone())
        .build();
  }
}
