package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntry {

  @Id
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;

  private String title;
  private String content;

  @ManyToOne
  private Patient patient;
}
