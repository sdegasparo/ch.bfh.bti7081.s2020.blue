package ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientHasChallengeId implements Serializable {

  private static final long serialVersionUID = 1L;

  private Patient patient;
  private Challenge challenge;
}
