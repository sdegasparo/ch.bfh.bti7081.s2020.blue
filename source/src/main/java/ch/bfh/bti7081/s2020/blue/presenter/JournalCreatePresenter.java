package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryCreateDto;
import ch.bfh.bti7081.s2020.blue.service.JournalEntryService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalCreateView;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalCreateView.JournalCreateListener;

public class JournalCreatePresenter implements JournalCreateListener {

  private final JournalCreateView view;
  private final JournalEntryCreateDto model;
  private final JournalEntryService journalEntryService;

  public JournalCreatePresenter(JournalEntryCreateDto journalEntryCreateDto, JournalCreateView view, BeanInjector beanInjector) {
    this.model = journalEntryCreateDto;
    this.view = view;
    this.journalEntryService = beanInjector.get(JournalEntryService.class);
  }

  public void onJournalEntryCreate() {
    journalEntryService.save(model);
  }
}
