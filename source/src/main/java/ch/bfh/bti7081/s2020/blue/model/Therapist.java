package ch.bfh.bti7081.s2020.blue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Therapist {

  private String title;
  private String surname;
  private String givenName;
  private String street;
  private String place;
  private String information;
}
