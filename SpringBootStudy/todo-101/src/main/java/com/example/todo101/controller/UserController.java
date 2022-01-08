package com.example.todo101.controller;

import com.example.todo101.dto.ResponseDTO;
import com.example.todo101.dto.UserDTO;
import com.example.todo101.model.UserEntity;
import com.example.todo101.security.TokenProvider;
import com.example.todo101.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {

  @Autowired
  UserService service;

  @Autowired
  TokenProvider tokenProvider;

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody UserDTO dto) {
    try {
      UserEntity entity = UserDTO.toEntity(dto);
      entity.setPassword(passwordEncoder.encode(dto.getPassword()));
      UserEntity registeredUser = service.create(entity);
      UserDTO responseUserDTO = new UserDTO(registeredUser);
      return ResponseEntity.ok().body(responseUserDTO);
    } catch (Exception e) {
      ResponseDTO<String> response = ResponseDTO.<String>builder().error(e.getMessage()).build();
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/signin")
  public ResponseEntity<?> authenticate(@RequestBody UserDTO dto) {
    UserEntity user = service.getByCredentials(dto.getEmail(), dto.getPassword(), passwordEncoder);

    if (user != null) {
      String token = tokenProvider.create(user);
      UserDTO responseUserDTO = new UserDTO(user);
      responseUserDTO.setToken(token);
      return ResponseEntity.ok().body(responseUserDTO);
    } else {
      ResponseDTO<String> response = ResponseDTO.<String>builder().error("Login failed.").build();
      return ResponseEntity.badRequest().body(response);
    }

  }
}
