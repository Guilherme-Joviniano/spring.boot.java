package br.com.joviniano.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
