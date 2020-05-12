package ch.bfh.bti7081.s2020.blue.domain;

import ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge.PatientHasChallenge;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {

  public static final String SEQUENCE_GENERATOR_STRATEGY = "org.hibernate.id.enhanced.SequenceStyleGenerator";

  @Id
  @GenericGenerator(name = "pk_sequence",
      strategy = SEQUENCE_GENERATOR_STRATEGY,
      parameters = {@Parameter(name = "sequence_name", value = "challenge_id_seq"),
          @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  private String name;
  private String content;
  private String criteria;

  @OneToMany(mappedBy = "challenge")
  private List<PatientHasChallenge> patients;
}
