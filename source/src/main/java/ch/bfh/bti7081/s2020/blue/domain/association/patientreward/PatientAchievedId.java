package ch.bfh.bti7081.s2020.blue.domain.association.patientreward;

import ch.bfh.bti7081.s2020.blue.domain.Achievement;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import java.io.Serializable;

public class PatientAchievedId implements Serializable {

  private static final long serialVersionUID = 1L;
  private Patient patient;
  private Achievement achievement;

  public PatientAchievedId() {
  }

  public PatientAchievedId(final Patient patient, final Achievement achievement) {
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
