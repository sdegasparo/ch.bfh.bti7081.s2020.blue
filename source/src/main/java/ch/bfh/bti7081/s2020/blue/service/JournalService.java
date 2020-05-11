package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JournalService {

  private List<JournalEntry> journalEntries = List.of(
      JournalEntry.builder()
          .id(1L)
          .title("This is a title")
          .content("This is content")
          .build(),
      JournalEntry.builder()
          .id(2L)
          .title("This is a title")
          .content("This is content")
          .build(),
      JournalEntry.builder()
          .id(3L)
          .title("This is a title")
          .content("This is content")
          .build()
  );

  public List<JournalEntry> findAll() {
    return journalEntries;
  }

  public JournalEntry findById(Long id) {
    return journalEntries.stream()
        .filter(journalEntry -> journalEntry.getId().equals(id))
        .findFirst()
        .get();
  }

}
