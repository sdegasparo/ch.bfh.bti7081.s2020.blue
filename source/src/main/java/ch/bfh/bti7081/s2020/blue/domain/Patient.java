package ch.bfh.bti7081.s2020.blue.domain;

import ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge.PatientHasChallenge;
import ch.bfh.bti7081.s2020.blue.domain.association.patientreward.PatientAchieved;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Patient {

  @Id
  @GenericGenerator(name = "pk_sequence", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "patient_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  private String surname;
  private String givenName;

  @OneToOne(cascade = CascadeType.ALL)
  private Login login;

  @OneToMany(mappedBy = "patient")
  private List<PatientHasChallenge> challenges;

  @OneToMany(mappedBy = "patient")
  private List<PatientAchieved> achievements;

  @OneToMany(mappedBy = "patient")
  private List<JournalEntry> journalEntries;

  public Patient() {
  }

  public Patient(final Long id, final String surname, final String givenName, final Login login, final List<PatientHasChallenge> challenges, final List<PatientAchieved> achievements, final List<JournalEntry> journalEntries) {
    this.id = id;
    this.surname = surname;
    this.givenName = givenName;
    this.login = login;
    this.challenges = challenges;
    this.achievements = achievements;
    this.journalEntries = journalEntries;
  }

  public static Patient.PatientBuilder builder() {
    return new Patient.PatientBuilder();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public String getGivenName() {
    return this.givenName;
  }

  public void setGivenName(final String givenName) {
    this.givenName = givenName;
  }

  public Login getLogin() {
    return this.login;
  }

  public void setLogin(final Login login) {
    this.login = login;
  }

  public List<PatientHasChallenge> getChallenges() {
    return this.challenges;
  }

  public void setChallenges(final List<PatientHasChallenge> challenges) {
    this.challenges = challenges;
  }

  public List<PatientAchieved> getAchievements() {
    return this.achievements;
  }

  public void setAchievements(final List<PatientAchieved> achievements) {
    this.achievements = achievements;
  }

  public List<JournalEntry> getJournalEntries() {
    return this.journalEntries;
  }

  public void setJournalEntries(final List<JournalEntry> journalEntries) {
    this.journalEntries = journalEntries;
  }

  public static class PatientBuilder {

    private Long id;
    private String surname;
    private String givenName;
    private Login login;
    private List<PatientHasChallenge> challenges;
    private List<PatientAchieved> achievements;
    private List<JournalEntry> journalEntries;

    PatientBuilder() {
    }

    public Patient.PatientBuilder id(final Long id) {
      this.id = id;
      return this;
    }

    public Patient.PatientBuilder surname(final String surname) {
      this.surname = surname;
      return this;
    }

    public Patient.PatientBuilder givenName(final String givenName) {
      this.givenName = givenName;
      return this;
    }

    public Patient.PatientBuilder login(final Login login) {
      this.login = login;
      return this;
    }

    public Patient.PatientBuilder challenges(final List<PatientHasChallenge> challenges) {
      this.challenges = challenges;
      return this;
    }

    public Patient.PatientBuilder achievements(final List<PatientAchieved> achievements) {
      this.achievements = achievements;
      return this;
    }

    public Patient.PatientBuilder journalEntries(final List<JournalEntry> journalEntries) {
      this.journalEntries = journalEntries;
      return this;
    }

    public Patient build() {
      return new Patient(this.id, this.surname, this.givenName, this.login, this.challenges, this.achievements, this.journalEntries);
    }

    @Override
    public java.lang.String toString() {
      return "Patient.PatientBuilder(id=" + this.id + ", surname=" + this.surname + ", givenName=" + this.givenName + ", login=" + this.login + ", challenges=" + this.challenges + ", achievements=" + this.achievements + ", journalEntries=" + this.journalEntries + ")";
    }
  }
}
