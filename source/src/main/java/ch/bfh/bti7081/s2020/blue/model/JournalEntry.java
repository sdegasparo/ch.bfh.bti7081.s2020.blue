package ch.bfh.bti7081.s2020.blue.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntry {

  private Date date;
  private String title;
  private String content;
}
