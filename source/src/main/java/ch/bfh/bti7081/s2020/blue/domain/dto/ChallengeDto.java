package ch.bfh.bti7081.s2020.blue.domain.dto;

public class ChallengeDto {

  private Long id;
  private String name;
  private String content;
  private String criteria;
  private Boolean accepted;
  private Boolean completed;

  public ChallengeDto(final Long id, final String name, final String content, final String criteria, final Boolean accepted, final Boolean completed) {
    this.id = id;
    this.name = name;
    this.content = content;
    this.criteria = criteria;
    this.accepted = accepted;
    this.completed = completed;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(final String content) {
    this.content = content;
  }

  public String getCriteria() {
    return this.criteria;
  }

  public void setCriteria(final String criteria) {
    this.criteria = criteria;
  }

  public Boolean getAccepted() {
    return this.accepted;
  }

  public void setAccepted(final Boolean accepted) {
    this.accepted = accepted;
  }

  public Boolean getCompleted() {
    return this.completed;
  }

  public void setCompleted(final Boolean completed) {
    this.completed = completed;
  }
}
