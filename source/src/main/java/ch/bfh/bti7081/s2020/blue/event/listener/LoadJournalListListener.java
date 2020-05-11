package ch.bfh.bti7081.s2020.blue.event.listener;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.event.LoadJournalListEvent;
import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LoadJournalListListener implements JournalListView.JournalListViewListener {

  private final JournalService journalService;

  public LoadJournalListListener(JournalService journalService) {
    this.journalService = journalService;
  }

  @Override
  public void onApplicationEvent(LoadJournalListEvent event) {
    List<JournalEntry> journalEntries = journalService.findAll();
    event.getSource().update(journalEntries);
  }
}
