package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.util.Beans;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView;

public class JournalDetailPresenter implements JournalDetailView.JournalDetailViewListener {

  private final JournalDetailView view;
  private final JournalService journalService;

  public JournalDetailPresenter(JournalDetailView view) {
    this.view = view;
    this.journalService = Beans.get(JournalService.class);
  }

  @Override
  public void findAndDisplay(Long id) {
    JournalEntry journalEntry = journalService.findById(id);
    view.display(journalEntry);
  }

  @Override
  public void saveButtonClick() {

  }

  @Override
  public void cancelButtonClick() {

  }
}
