package ch.bfh.bti7081.s2020.blue.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class RegisterDto {

  @Size(min = 4, max = 128)
  private String username;

  @Size(min = 6, max = 128)
  private String password;

  @Size(min = 6, max = 128)
  private String repeatPassword;

  @Email
  private String email;

  @Size(min = 2, max = 128)
  private String surname;

  @Size(min = 2, max = 128)
  private String givenName;
  private String message;

  public RegisterDto() {
  }

  public RegisterDto(final String username, final String password, final String repeatPassword, final String email, final String surname, final String givenName, final String message) {
    this.username = username;
    this.password = password;
    this.repeatPassword = repeatPassword;
    this.email = email;
    this.surname = surname;
    this.givenName = givenName;
    this.message = message;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getRepeatPassword() {
    return this.repeatPassword;
  }

  public void setRepeatPassword(final String repeatPassword) {
    this.repeatPassword = repeatPassword;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public String getGivenName() {
    return this.givenName;
  }

  public void setGivenName(final String givenName) {
    this.givenName = givenName;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
