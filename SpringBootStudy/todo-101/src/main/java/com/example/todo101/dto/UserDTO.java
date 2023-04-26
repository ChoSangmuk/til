package com.example.todo101.dto;

import com.example.todo101.model.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private String token;
  private String id;
  private String name;
  private String password;
  private String email;

  public UserDTO(UserEntity entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.password = entity.getPassword();
    this.email = entity.getEmail();
  }

  public static UserEntity toEntity(UserDTO dto) {
    return UserEntity.builder()
        .id(dto.getId())
        .name(dto.getName())
        .password(dto.getPassword())
        .email(dto.getEmail())
        .build();
  }
}
