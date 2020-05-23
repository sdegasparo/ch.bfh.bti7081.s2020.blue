package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView.JournalListListener;
import java.util.Collection;
import java.util.Optional;

public class JournalListPresenter implements JournalListListener {

  private final JournalListView view;
  private final JournalService journalService;

  public JournalListPresenter(JournalListView journalView, BeanInjector beanInjector) {
    this.view = journalView;
    this.journalService = beanInjector.get(JournalService.class);
  }

  @Override
  public void onInit(Optional<Long> selectedEntry) {
    showEntry(selectedEntry);
  }

  @Override
  public void journalEntrySelected(Long entryId) {
    showEntry(Optional.ofNullable(entryId));
  }

  private void showEntry(Optional<Long> selectedId) {
    Collection<JournalEntry> entries = journalService.findAll();
    Optional<JournalEntry> entry = selectedId.flatMap(id -> journalService.findById(id));
    // Only show the entry if screen is big enough.
    if (entry.isPresent()) {
      if (view.getScreenSize() > 600) {
        view.display(entries, entry);
      } else {
        view.navigate(String.format("journal/%d", entry.get().getId()));
      }
    } else {
      view.display(entries, Optional.empty());
    }
  }
}
