package ch.bfh.bti7081.s2020.blue.domain.association.patientreward;

import ch.bfh.bti7081.s2020.blue.domain.Achievement;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientAchievedId implements Serializable {

  private static final long serialVersionUID = 1L;

  private Patient patient;
  private Achievement achievement;
}
