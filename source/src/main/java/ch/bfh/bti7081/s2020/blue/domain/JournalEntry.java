package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class JournalEntry {

  @Id
  @GenericGenerator(name = "pk_sequence", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "journal_entry_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  private String title;
  private String content;

  @ManyToOne
  private Patient patient;

  public JournalEntry() {
  }

  public JournalEntry(final Long id, final Date creationDate, final String title, final String content, final Patient patient) {
    this.id = id;
    this.creationDate = creationDate;
    this.title = title;
    this.content = content;
    this.patient = patient;
  }

  public static JournalEntry.JournalEntryBuilder builder() {
    return new JournalEntry.JournalEntryBuilder();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Date getCreationDate() {
    return this.creationDate;
  }

  public void setCreationDate(final Date creationDate) {
    this.creationDate = creationDate;
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

  public Patient getPatient() {
    return this.patient;
  }

  public void setPatient(final Patient patient) {
    this.patient = patient;
  }

  public static class JournalEntryBuilder {

    private Long id;
    private Date creationDate;
    private String title;
    private String content;
    private Patient patient;

    JournalEntryBuilder() {
    }

    public JournalEntry.JournalEntryBuilder id(final Long id) {
      this.id = id;
      return this;
    }

    public JournalEntry.JournalEntryBuilder creationDate(final Date creationDate) {
      this.creationDate = creationDate;
      return this;
    }

    public JournalEntry.JournalEntryBuilder title(final String title) {
      this.title = title;
      return this;
    }

    public JournalEntry.JournalEntryBuilder content(final String content) {
      this.content = content;
      return this;
    }

    public JournalEntry.JournalEntryBuilder patient(final Patient patient) {
      this.patient = patient;
      return this;
    }

    public JournalEntry build() {
      return new JournalEntry(this.id, this.creationDate, this.title, this.content, this.patient);
    }

    @Override
    public java.lang.String toString() {
      return "JournalEntry.JournalEntryBuilder(id=" + this.id + ", creationDate=" + this.creationDate + ", title=" + this.title + ", content=" + this.content + ", patient=" + this.patient + ")";
    }
  }
}
