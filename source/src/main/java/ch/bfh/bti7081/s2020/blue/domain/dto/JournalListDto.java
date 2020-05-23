package ch.bfh.bti7081.s2020.blue.domain.dto;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class JournalListDto {

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class RegisterDto {

    private String search;

    private Collection<JournalEntry> entries;

    private JournalEntry selectedEntry;

    private String message;
  }

}
