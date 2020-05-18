package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView;

public class JournalListPresenter implements JournalListView.JournalListViewListener {

  private final JournalListView view;
  private final JournalService journalService;

  public JournalListPresenter(JournalListView view, BeanInjector beanInjector) {
    this.view = view;
    this.journalService = beanInjector.get(JournalService.class);
  }

  @Override
  public void onInit() {
    view.display(journalService.findAll());
  }
}
