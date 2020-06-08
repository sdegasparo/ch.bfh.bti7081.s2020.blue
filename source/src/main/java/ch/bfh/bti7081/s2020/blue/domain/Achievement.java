package ch.bfh.bti7081.s2020.blue.domain;

import ch.bfh.bti7081.s2020.blue.domain.association.patientreward.PatientAchieved;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Achievement {

  @Id
  @GenericGenerator(name = "pk_sequence", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "achievement_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  private String name;
  private String description;

  @OneToMany(mappedBy = "achievement")
  private List<PatientAchieved> patients = new ArrayList<>();

  @OneToMany(mappedBy = "achievement")
  private List<Reward> rewardedBy = new ArrayList<>();

  public Achievement() {
  }

  public Achievement(final String name, final String description) {
    this.name = name;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public List<PatientAchieved> getPatients() {
    return this.patients;
  }

  public void setPatients(final List<PatientAchieved> patients) {
    this.patients = patients;
  }

  public List<Reward> getRewardedBy() {
    return this.rewardedBy;
  }

  public void setRewardedBy(final List<Reward> rewardedBy) {
    this.rewardedBy = rewardedBy;
  }
}
