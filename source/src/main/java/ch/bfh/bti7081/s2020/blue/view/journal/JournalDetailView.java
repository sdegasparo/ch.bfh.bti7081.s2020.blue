package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;

public interface JournalDetailView {

  void display(JournalEntry journalEntry);

  interface JournalDetailListener {

    void onInit(Long id);
  }
}
