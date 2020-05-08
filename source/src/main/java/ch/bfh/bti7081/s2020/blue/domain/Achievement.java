package ch.bfh.bti7081.s2020.blue.domain;

import ch.bfh.bti7081.s2020.blue.domain.association.patientreward.PatientAchieved;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {

  @Id
  private Long id;

  private String name;
  private String description;

  @OneToMany(mappedBy = "achievement")
  private List<PatientAchieved> patients;

  @OneToMany(mappedBy = "achievement")
  private List<Reward> rewardedBy;
}
