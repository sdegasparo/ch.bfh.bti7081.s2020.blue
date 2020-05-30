package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.List;

public interface JournalListView {

  void display(List<JournalEntry> journalEntries);

  void navigateToJournalEntryCreate();

  void navigateToDetailView(Long id);

  interface JournalListListener {

    void onInit();

    void onJournalEntryAddClick();

    void onJournalEntryClick(Long id);
  }
}
