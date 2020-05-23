package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.Collection;
import java.util.Optional;

public interface JournalListView {

  void display(Collection<JournalEntry> entries, Optional<JournalEntry> selected);

  int getScreenSize();

  void navigate(String route);

  interface JournalListListener {

    void onInit(Optional<Long> selectedEntry);

    void journalEntrySelected(Long entryId);
  }
}
