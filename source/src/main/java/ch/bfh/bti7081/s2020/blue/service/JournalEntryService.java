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

  public List<JournalEntry> findAllByCurrentUser() {
    return journalEntryCrudRepository.findAllByCurrentUser();
  }

  public void save(JournalEntryDto journalEntryDto) {
    journalEntryCrudRepository.create(journalEntryDto.getTitle(), journalEntryDto.getContent(), new Date());
  }

  public void update(JournalEntryDto journalEntryDto) {
    journalEntryCrudRepository.update(journalEntryDto.getId(), journalEntryDto.getTitle(), journalEntryDto.getContent(), new Date());
  }

  public JournalEntry findById(Long id) {
    return journalEntryCrudRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("JournalEntry with id %s not found", id)));
  }

  public void deleteById(Long id) {
    journalEntryCrudRepository.deleteById(id);
  }
}
