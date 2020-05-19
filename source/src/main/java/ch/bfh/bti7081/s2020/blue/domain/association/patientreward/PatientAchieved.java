package ch.bfh.bti7081.s2020.blue.domain.association.patientreward;

import ch.bfh.bti7081.s2020.blue.domain.Achievement;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PatientAchievedId.class)
public class PatientAchieved {

  @Id
  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @Id
  @ManyToOne
  @JoinColumn(name = "achievement_id")
  private Achievement achievement;
}
