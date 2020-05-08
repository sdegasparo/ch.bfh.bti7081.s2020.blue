package ch.bfh.bti7081.s2020.blue.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
  private String username;
  private String password;
  private String repeatPassword;
  private String email;
  private String surname;
  private String givenName;
}
