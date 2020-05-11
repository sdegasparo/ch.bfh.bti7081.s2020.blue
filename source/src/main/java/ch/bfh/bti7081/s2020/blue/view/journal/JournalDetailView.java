package ch.bfh.bti7081.s2020.blue.view.journal;

public interface JournalDetailView {

  interface JournalDetailViewListener {

    void saveButtonClick();

    void cancelButtonClick();
  }

  public void addListener(JournalDetailViewListener listener);
}
