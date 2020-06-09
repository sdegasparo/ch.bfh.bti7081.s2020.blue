package ch.bfh.bti7081.s2020.blue.domain.dto;

public class JournalEntryDto {

  private Long id;
  private String title;
  private String content;

  public JournalEntryDto() {
  }

  public JournalEntryDto(final Long id, final String title, final String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(final String content) {
    this.content = content;
  }
}
