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
  @GenericGenerator(name = "journal_entry_id_seq", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "journal_entry_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "journal_entry_id_seq")
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate = new Date();

  private String title;
  private String content;

  @ManyToOne
  private Patient patient;

  public JournalEntry() {
  }

  public JournalEntry(final String title, final String content, final Patient patient) {
    this.title = title;
    this.content = content;
    this.patient = patient;
  }

  public Long getId() {
    return this.id;
  }

  public Date getCreationDate() {
    return this.creationDate;
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
}
