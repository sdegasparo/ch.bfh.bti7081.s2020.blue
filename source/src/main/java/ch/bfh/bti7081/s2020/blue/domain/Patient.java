package ch.bfh.bti7081.s2020.blue.domain;

import ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge.PatientHasChallenge;
import ch.bfh.bti7081.s2020.blue.domain.association.patientreward.PatientAchieved;
import java.util.ArrayList;
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
  @GenericGenerator(name = "patient_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "patient_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_seq")
  private Long id;

  private String surname;
  private String givenName;

  @OneToOne(cascade = CascadeType.ALL)
  private Login login;

  @OneToMany(mappedBy = "patient")
  private List<PatientHasChallenge> challenges = new ArrayList<>();

  @OneToMany(mappedBy = "patient")
  private List<PatientAchieved> achievements = new ArrayList<>();

  @OneToMany(mappedBy = "patient")
  private List<JournalEntry> journalEntries = new ArrayList<>();

  public Patient() {
  }

  public Patient(final String surname, final String givenName, final Login login) {
    this.surname = surname;
    this.givenName = givenName;
    this.login = login;
  }

  public Long getId() {
    return this.id;
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
}
