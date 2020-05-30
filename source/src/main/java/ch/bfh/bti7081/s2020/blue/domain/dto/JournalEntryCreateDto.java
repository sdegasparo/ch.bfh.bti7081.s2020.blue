package ch.bfh.bti7081.s2020.blue.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryCreateDto {

  private String title;
  private String content;
}
