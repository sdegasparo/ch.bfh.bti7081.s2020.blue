package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;

public interface JournalDetailView {

  void display(JournalEntry journalEntry);

  interface JournalDetailViewListener {

    void findAndDisplay(Long id);

    void saveButtonClick();

    void cancelButtonClick();
  }

  void addListener(JournalDetailViewListener listener);
}
