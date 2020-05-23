package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.domain.dto.JournalListDto;
import java.util.Collection;
import java.util.Optional;

public interface JournalListView {

  void display(JournalListDto dto);

  int getScreenSize();

  void navigate(String route);

  Long getSelectedEntryId();

  String getSearchFieldValue();

  interface JournalListListener {

    void onInit(Long selectedEntry);

    void journalEntrySelected(Long entryId);

    void searchFieldChanged();

    void addNewClicked();
  }
}
