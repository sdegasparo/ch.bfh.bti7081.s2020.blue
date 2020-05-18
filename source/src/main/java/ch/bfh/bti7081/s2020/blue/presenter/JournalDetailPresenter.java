package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView;

public class JournalDetailPresenter implements JournalDetailView.JournalDetailViewListener {

  private final JournalDetailView view;
  private final JournalService journalService;

  public JournalDetailPresenter(JournalDetailView view, BeanInjector beanInjector) {
    this.view = view;
    this.journalService = beanInjector.get(JournalService.class);
  }

  @Override
  public void onInit(Long id) {
    view.display(journalService.findById(id));
  }
}
