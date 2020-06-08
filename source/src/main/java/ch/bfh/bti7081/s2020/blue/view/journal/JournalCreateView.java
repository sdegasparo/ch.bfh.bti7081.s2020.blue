package ch.bfh.bti7081.s2020.blue.view.journal;

public interface JournalCreateView {

  void navigateToDetailView(Long journalId);

  interface JournalCreateListener {

    void onJournalEntryCreate();
  }
}
