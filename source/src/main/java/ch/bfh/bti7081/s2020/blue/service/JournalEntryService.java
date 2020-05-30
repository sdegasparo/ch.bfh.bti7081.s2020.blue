package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryDto;
import ch.bfh.bti7081.s2020.blue.domain.repository.JournalEntryCrudRepository;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService {

  public JournalEntryCrudRepository journalEntryCrudRepository;

  public JournalEntryService(JournalEntryCrudRepository journalEntryCrudRepository) {
    this.journalEntryCrudRepository = journalEntryCrudRepository;
  }

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

  public List<JournalEntry> findAllForCurrentUser() {
    // TODO by user
    return journalEntryCrudRepository.findAll();
  }

  public void save(JournalEntryDto journalEntryDto) {
    journalEntryCrudRepository.create(journalEntryDto.getTitle(), journalEntryDto.getContent(), new Date());
  }

  public void update(JournalEntryDto journalEntryDto) {
    journalEntryCrudRepository.update(journalEntryDto.getTitle(), journalEntryDto.getContent(), new Date());
  }

  public JournalEntry findById(Long id) {
    return journalEntryCrudRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("JournalEntry with id %s not found", id)));
  }
}
