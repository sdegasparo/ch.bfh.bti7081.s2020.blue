package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reward {

  @Id
  private Long id;

  private String name;
  private String description;

  @Column(columnDefinition = "int2")
  private Integer points;

  @ManyToOne
  private Achievement achievement;

  public Optional<Achievement> getAchievement() {
    return Optional.ofNullable(achievement);
  }
}
