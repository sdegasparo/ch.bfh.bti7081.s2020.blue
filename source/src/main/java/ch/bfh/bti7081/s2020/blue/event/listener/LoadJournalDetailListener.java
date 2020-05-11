package ch.bfh.bti7081.s2020.blue.event.listener;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.event.LoadJournalDetailEvent;
import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.view.VaadinView;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoadJournalDetailListener implements ApplicationListener<LoadJournalDetailEvent> {

  private final JournalService journalService;

  public LoadJournalDetailListener(JournalService journalService) {
    this.journalService = journalService;
  }

  @Override
  public void onApplicationEvent(LoadJournalDetailEvent event) {
    VaadinView<JournalEntry> source = (VaadinView<JournalEntry>) event.getSource();

    JournalEntry journalEntry = loadJournalEntry(event.getJournalEntryId());
    source.update(journalEntry);
  }

  private JournalEntry loadJournalEntry(Long journalEntryId) {
    return journalService.findById(journalEntryId);
  }
}
