package ch.bfh.bti7081.s2020.blue.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Therapist {

  @Id
  private Long id;

  private String title;
  private String surname;
  private String givenName;
  private String street;
  private String place;
  private String information;
}
