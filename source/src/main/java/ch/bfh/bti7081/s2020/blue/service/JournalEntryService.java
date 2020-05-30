package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryCreateDto;
import ch.bfh.bti7081.s2020.blue.domain.repository.JournalentryCrudRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService {

  public JournalentryCrudRepository journalentryCrudRepository;

  public JournalEntryService(JournalentryCrudRepository journalentryCrudRepository) {
    this.journalentryCrudRepository = journalentryCrudRepository;
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
    return journalentryCrudRepository.findAll();
  }

  public Optional<JournalEntry> findByIdForCurrentUser(Long id) {
    return journalEntries.stream()
        .filter(journalEntry -> journalEntry.getId().equals(id))
        .findFirst();
  }

  public void save(JournalEntryCreateDto journalEntryCreateDto) {
    journalentryCrudRepository.save(journalEntryCreateDto.getTitle(), journalEntryCreateDto.getContent(), new Date());
  }
}
