package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.event.LoadJournalListEvent;
import ch.bfh.bti7081.s2020.blue.view.VaadinView;
import java.util.List;
import org.springframework.context.ApplicationListener;

public interface JournalListView extends VaadinView<List<JournalEntry>> {

  interface JournalListViewListener extends ApplicationListener<LoadJournalListEvent> {

  }
}
