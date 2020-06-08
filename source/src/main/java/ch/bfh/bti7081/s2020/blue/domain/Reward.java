package ch.bfh.bti7081.s2020.blue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Reward {

  @Id
  @GenericGenerator(name = "pk_sequence", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "reward_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  private String name;
  private String description;

  @Column(columnDefinition = "int2")
  private Integer points;

  @ManyToOne
  private Achievement achievement;

  public Reward() {
  }

  public Reward(final String name, final String description, final Integer points) {
    this.name = name;
    this.description = description;
    this.points = points;
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

  public Integer getPoints() {
    return this.points;
  }

  public void setPoints(final Integer points) {
    this.points = points;
  }

  public Achievement getAchievement() {
    return this.achievement;
  }

  public void setAchievement(final Achievement achievement) {
    this.achievement = achievement;
  }
}
