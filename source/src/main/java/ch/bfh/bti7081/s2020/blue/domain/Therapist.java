package ch.bfh.bti7081.s2020.blue.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Therapist {

  @Id
  @GenericGenerator(name = "pk_sequence",
      strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY,
      parameters = {@Parameter(name = "sequence_name", value = "therapist_id_seq"),
          @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  private String title;
  private String surname;
  private String givenName;
  private String street;
  private String place;
  private String information;
}
