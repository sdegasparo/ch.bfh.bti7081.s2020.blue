package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JournalService {

  private final List<JournalEntry> journalEntries = List.of(
      JournalEntry.builder()
          .id(1L)
          .title("Journal Day 3")
          .content("What day is it?")
          .build(),
      JournalEntry.builder()
          .id(2L)
          .title("Journal Day 2")
          .content("Oh no ..")
          .build(),
      JournalEntry.builder()
          .id(3L)
          .title("Journal Day 1")
          .content("This is the beginning of ..")
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
