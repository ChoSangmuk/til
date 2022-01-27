package com.example.todo101.dto;

import com.example.todo101.model.TestEntity;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestRequestDTO {
  private String name;
  private String message;

  public TestRequestDTO(TestEntity testEntity) {
    this.name = testEntity.getName();
    this.message = testEntity.getMessage();
  }
}
