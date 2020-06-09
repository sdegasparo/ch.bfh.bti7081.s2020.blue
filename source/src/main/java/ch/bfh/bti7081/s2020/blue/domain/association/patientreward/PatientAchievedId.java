package ch.bfh.bti7081.s2020.blue.domain.association.patientreward;

import ch.bfh.bti7081.s2020.blue.domain.Achievement;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import java.io.Serializable;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PatientAchievedId implements Serializable {

  private static final long serialVersionUID = 1L;

  private Patient patient;
  private Achievement achievement;

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

  @Override
  public boolean equals(Object o) {
    return o instanceof PatientAchievedId
        && getPatient().equals(((PatientAchievedId) o).getPatient())
        && getAchievement().equals(((PatientAchievedId) o).getAchievement());
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(getPatient())
        .append(getAchievement())
        .build();
  }
}
