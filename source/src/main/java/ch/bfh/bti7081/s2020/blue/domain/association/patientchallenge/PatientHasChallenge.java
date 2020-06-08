package ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(PatientHasChallengeId.class)
public class PatientHasChallenge {

  @Id
  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @Id
  @ManyToOne
  @JoinColumn(name = "challenge_id")
  private Challenge challenge;
  private Boolean completed;

  public PatientHasChallenge() {
  }

  public PatientHasChallenge(final Patient patient, final Challenge challenge, final Boolean completed) {
    this.patient = patient;
    this.challenge = challenge;
    this.completed = completed;
  }

  public static PatientHasChallenge.PatientHasChallengeBuilder builder() {
    return new PatientHasChallenge.PatientHasChallengeBuilder();
  }

  public Patient getPatient() {
    return this.patient;
  }

  public void setPatient(final Patient patient) {
    this.patient = patient;
  }

  public Challenge getChallenge() {
    return this.challenge;
  }

  public void setChallenge(final Challenge challenge) {
    this.challenge = challenge;
  }

  public Boolean getCompleted() {
    return this.completed;
  }

  public void setCompleted(final Boolean completed) {
    this.completed = completed;
  }

  public static class PatientHasChallengeBuilder {

    private Patient patient;
    private Challenge challenge;
    private Boolean completed;

    PatientHasChallengeBuilder() {
    }

    public PatientHasChallenge.PatientHasChallengeBuilder patient(final Patient patient) {
      this.patient = patient;
      return this;
    }

    public PatientHasChallenge.PatientHasChallengeBuilder challenge(final Challenge challenge) {
      this.challenge = challenge;
      return this;
    }

    public PatientHasChallenge.PatientHasChallengeBuilder completed(final Boolean completed) {
      this.completed = completed;
      return this;
    }

    public PatientHasChallenge build() {
      return new PatientHasChallenge(this.patient, this.challenge, this.completed);
    }

    @Override
    public java.lang.String toString() {
      return "PatientHasChallenge.PatientHasChallengeBuilder(patient=" + this.patient + ", challenge=" + this.challenge + ", completed=" + this.completed + ")";
    }
  }
}
