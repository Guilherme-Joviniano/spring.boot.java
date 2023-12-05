package br.com.joviniano.ioc_di;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
  public String callMyComponent() {
    return "Calling my Component";
  }
}
