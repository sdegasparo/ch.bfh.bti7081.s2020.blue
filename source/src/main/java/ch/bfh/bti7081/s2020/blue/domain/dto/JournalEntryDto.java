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

  public static JournalEntryDto.JournalEntryDtoBuilder builder() {
    return new JournalEntryDto.JournalEntryDtoBuilder();
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

  public static class JournalEntryDtoBuilder {

    private Long id;
    private String title;
    private String content;

    JournalEntryDtoBuilder() {
    }

    public JournalEntryDto.JournalEntryDtoBuilder id(final Long id) {
      this.id = id;
      return this;
    }

    public JournalEntryDto.JournalEntryDtoBuilder title(final String title) {
      this.title = title;
      return this;
    }

    public JournalEntryDto.JournalEntryDtoBuilder content(final String content) {
      this.content = content;
      return this;
    }

    public JournalEntryDto build() {
      return new JournalEntryDto(this.id, this.title, this.content);
    }

    @Override
    public java.lang.String toString() {
      return "JournalEntryDto.JournalEntryDtoBuilder(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ")";
    }
  }
}
