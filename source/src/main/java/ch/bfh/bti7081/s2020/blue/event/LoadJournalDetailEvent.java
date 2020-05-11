package ch.bfh.bti7081.s2020.blue.event;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;

public class LoadJournalDetailEvent extends VaadinEvent<JournalEntry> {

  private final Long journalEntryId;

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with which the event is
   * associated (never {@code null})
   */
  public LoadJournalDetailEvent(Object source, Long journalEntryId) {
    super(source);

    this.journalEntryId = journalEntryId;
  }

  public Long getJournalEntryId() {
    return this.journalEntryId;
  }
}
