package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryDto;
import ch.bfh.bti7081.s2020.blue.service.JournalEntryService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalCreateView;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalCreateView.JournalCreateListener;

public class JournalCreatePresenter implements JournalCreateListener {

  private final JournalCreateView view;
  private final JournalEntryDto model;
  private final JournalEntryService journalEntryService;

  public JournalCreatePresenter(JournalEntryDto journalEntryDto, JournalCreateView view, BeanInjector beanInjector) {
    this.model = journalEntryDto;
    this.view = view;
    this.journalEntryService = beanInjector.get(JournalEntryService.class);
  }

  @Override
  public void onJournalEntryCreate() {
    journalEntryService.save(model);
  }
}
