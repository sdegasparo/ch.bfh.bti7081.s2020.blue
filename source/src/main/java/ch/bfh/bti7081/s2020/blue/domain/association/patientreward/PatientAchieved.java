package ch.bfh.bti7081.s2020.blue.domain.association.patientreward;

import ch.bfh.bti7081.s2020.blue.domain.Achievement;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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

  public PatientAchieved() {
  }

  public PatientAchieved(final Patient patient, final Achievement achievement) {
    this.patient = patient;
    this.achievement = achievement;
  }

  public Patient getPatient() {
    return this.patient;
  }

  public void setPatient(final Patient patient) {
    this.patient = patient;
  }

  public Achievement getAchievement() {
    return this.achievement;
  }

  public void setAchievement(final Achievement achievement) {
    this.achievement = achievement;
  }
}
