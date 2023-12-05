package br.com.joviniano.job_offer_manager.modules.candidate;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CandidateEntity {
  private UUID id;

  @Email(message = "The field (email) must to contains a valid e-mail")
  private String email;

  @NotBlank()
  @Pattern(regexp = "\\S+", message = "The field [username] must not contains spaces")
  private String name;

  private String password;
  private String description;
  private String curriculum;

  public String getCurriculum() {
    return curriculum;
  }

  public void setCurriculum(String curriculum) {
    this.curriculum = curriculum;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
