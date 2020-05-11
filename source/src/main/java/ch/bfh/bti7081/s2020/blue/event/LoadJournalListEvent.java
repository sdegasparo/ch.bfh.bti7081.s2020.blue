package ch.bfh.bti7081.s2020.blue.event;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.List;

public class LoadJournalListEvent extends VaadinEvent<List<JournalEntry>> {

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with which the event is
   * associated (never {@code null})
   */
  public LoadJournalListEvent(Object source) {
    super(source);
  }
}
