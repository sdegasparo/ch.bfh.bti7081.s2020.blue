package ch.bfh.bti7081.s2020.blue.domain;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
