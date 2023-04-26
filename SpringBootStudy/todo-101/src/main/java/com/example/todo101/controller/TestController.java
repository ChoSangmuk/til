package com.example.todo101.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.todo101.dto.TestResponseDTO;
import com.example.todo101.dto.TestRequestDTO;
import com.example.todo101.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

  @Autowired
  TestService testService;

  @GetMapping
  public String test() {
    return "test()";
  }

  @GetMapping("getMapping")
  public String testPath() {
    return "testPath() getMapping";
  }

  @GetMapping("/{id}")
  public String testPathVariableString(@PathVariable String id) {
    return "testPathVariableString() PathVariable = " + id;
  }

  @GetMapping("/requestParam")
  public String testRequestParam(@RequestParam int id) {
    return "testRequestParam() RequestParam = " + id;
  }

  @GetMapping("/requestBody")
  public String testRequestBody(@RequestBody TestRequestDTO dto) {
    return "testRequestBody() RequestBody = " + dto.toString();
  }

  @GetMapping("/responseBody")
  public TestResponseDTO<String> testResponseBody(@RequestBody TestRequestDTO dto) {
    List<String> list = new ArrayList<String>();
    list.add("testResponseBody() " + dto.getName());
    list.add("testResponseBody() " + dto.getMessage());
    TestResponseDTO<String> response = TestResponseDTO.<String>builder().data(list).build();
    return response;
  }

  @GetMapping("/responseEntity")
  public ResponseEntity<?> testResponseEntity(@RequestBody TestRequestDTO dto) {
    List<String> list = new ArrayList<String>();
    list.add("testResponseEntity() " + dto.getName());
    list.add("testResponseEntity() " + dto.getMessage());
    TestResponseDTO<String> response = TestResponseDTO.<String>builder().data(list).build();
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/service")
  public ResponseEntity<?> testService() {
    List<String> list = new ArrayList<String>();
    list.add("testService() " + testService.testService() + " 1");
    list.add("testService() " + testService.testService() + " 2");
    TestResponseDTO<String> response = TestResponseDTO.<String>builder().data(list).build();
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/persistence")
  public ResponseEntity<?> testPersistence() {
    List<String> list = new ArrayList<String>();
    list.add("testPersistence() " + testService.testPersistence() + " 1");
    list.add("testPersistence() " + testService.testPersistence() + " 2");
    TestResponseDTO<String> response = TestResponseDTO.<String>builder().data(list).build();
    return ResponseEntity.ok().body(response);
  }
}
