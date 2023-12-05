package br.com.joviniano.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

  @GetMapping("/{name}")
  public String greeting(
      @PathVariable String name) {
    return "Hello " + name;
  }

  @GetMapping("")
  public String greeting2(
      @RequestParam String id,
      @RequestParam String name) {
    return "Hello " + id + " " + name;
  }

  @GetMapping("/query")
  public String greeting3(@RequestParam Map<String, String> allParams) {
    return "O parametro com é " + allParams.entrySet();
  }

  @PostMapping("/")
  public String greetingPost(@RequestBody User user) {
    return user.username;
  }

  record User(String username) {
  }

  @PostMapping("/withHeaders")
  public String greetingPostWithHeaders(@RequestHeader("x-name") String name) {
    return name;
  }

  @PostMapping("/withListHeaders")
  public String greetingPostWithListHeaders(@RequestHeader Map<String, String> headers) {
    return "" + headers.entrySet();
  }

  @GetMapping("/responseEntity/{id}")
  public ResponseEntity<Object> responseEntity(@PathVariable Long id) {
    var user = new User("Joviniano");
    if (id > 5) {
      return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    return ResponseEntity.badRequest().body("Error: Number is lower than five (5)");
  }
}
