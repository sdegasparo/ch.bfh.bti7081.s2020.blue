package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.JournalEntryService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView.JournalDetailListener;

public class JournalDetailPresenter implements JournalDetailListener {

  private final JournalDetailView view;
  private final JournalEntryService journalEntryService;

  public JournalDetailPresenter(JournalDetailView view, BeanInjector beanInjector) {
    this.view = view;
    this.journalEntryService = beanInjector.get(JournalEntryService.class);
  }

  @Override
  public void onInit(Long id) {
    view.display(journalEntryService.findById(id));
  }
}
