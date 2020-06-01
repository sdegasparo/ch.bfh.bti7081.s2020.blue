package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryDto;
import ch.bfh.bti7081.s2020.blue.service.JournalEntryService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView.JournalDetailListener;

public class JournalDetailPresenter implements JournalDetailListener {

  private final JournalDetailView view;
  private JournalEntryDto model;
  private final JournalEntryService journalEntryService;

  public JournalDetailPresenter(JournalDetailView view, BeanInjector beanInjector) {
    this.view = view;
    this.journalEntryService = beanInjector.get(JournalEntryService.class);
  }

  @Override
  public void afterViewInit(Long id) {
    JournalEntry journalEntry = journalEntryService.findById(id);
    JournalEntryDto journalEntryDto = JournalEntryDto.builder()
        .id(journalEntry.getId())
        .title(journalEntry.getTitle())
        .content(journalEntry.getContent())
        .build();
    view.afterViewInit(journalEntryDto);
  }

  @Override
  public void onJournalEntryUpdate() {
    journalEntryService.update(model);
  }

  @Override
  public void onJournalEntryDelete() {
    journalEntryService.deleteById(model.getId());
    view.routeToHomeView();
  }

  @Override
  public void setModel(JournalEntryDto journalEntryDto) {
    this.model = journalEntryDto;
  }
}
