package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.List;

public interface JournalListView {

  void display(List<JournalEntry> journalEntries);

  interface JournalListListener {

    void onInit();

//    void onInit(Long selectedEntry);

//    void journalEntrySelected(Long entryId);
//
//    void searchFieldChanged();
//
//    void addNewClicked();
  }
}
