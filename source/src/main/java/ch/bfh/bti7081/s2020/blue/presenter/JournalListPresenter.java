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
  public void onJournalEntryClick(Long id) {
    view.navigateToDetailView(id);
  }
}
