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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
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
}
