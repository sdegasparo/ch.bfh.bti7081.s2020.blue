package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryDto;

public interface JournalDetailView {

  void afterViewInit(JournalEntryDto journalEntryDto);

  interface JournalDetailListener {

    void afterViewInit(Long id);

    void onJournalEntryUpdate();

    void setModel(JournalEntryDto journalEntryDto);
  }
}
