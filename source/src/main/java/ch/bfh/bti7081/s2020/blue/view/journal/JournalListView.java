package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.List;

public interface JournalListView {

  void onInit(List<JournalEntry> journalEntries);

  interface JournalListViewListener {

    void onInit();

  }
}
