package ch.bfh.bti7081.s2020.blue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login {

  @Id
  private String username;

  private String email;

  @Column(columnDefinition = "BPCHAR(60)")
  private String password;

  private Boolean isEnabled;
  private Boolean isBlocked;

  @OneToOne(mappedBy = "login")
  private Patient patient;
}
