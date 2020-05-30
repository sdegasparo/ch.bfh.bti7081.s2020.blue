package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.JournalEntryService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView.JournalListListener;

public class JournalListPresenter implements JournalListListener {

  private final JournalListView view;
  private final JournalEntryService journalEntryService;

  public JournalListPresenter(JournalListView journalView, BeanInjector beanInjector) {
    this.view = journalView;
    this.journalEntryService = beanInjector.get(JournalEntryService.class);
  }

  @Override
  public void onInit() {
    view.display(journalEntryService.findAllForCurrentUser());
  }

  @Override
  public void onJournalEntryAddClick() {
    view.navigateToJournalEntryCreate();
  }

  @Override
  public void onJournalClick(Long id) {
    view.navigateToDetailView(id);
  }

//  @Override
//  public void onInit(Long selectedEntry) {
//    showEntry(selectedEntry, null);
//  }
//
//  @Override
//  public void journalEntrySelected(Long entryId) {
//    showEntry(entryId, null);
//  }
//
//  @Override
//  public void searchFieldChanged() {
//    showEntry(null, value);
//  }
//
//  @Override
//  public void addNewClicked() {
//    view.navigate(String.format("journal/new"));
//  }
//
//  private void showEntry(Long selectedId, String search) {
//    Collection<JournalEntry> entries = journalService.findAllForCurrentUser(search);
//
//    Optional<JournalEntry> entry = entries.stream().filter(e -> e.getId().equals(selectedId))
//        .findFirst();
//    // Only show the entry if screen is big enough.
//    if (entry.isPresent()) {
//      if (view.getScreenSize() > 600) {
//        view.display(entries, entry.get());
//      } else {
//        view.navigate(String.format("journal/%d", entry.get().getId()));
//      }
//    } else {
//      view.display(entries, null);
//    }
//  }
}
