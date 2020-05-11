package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView;
import org.springframework.stereotype.Component;

@Component
public class JournalDetailPresenter implements JournalDetailView.JournalDetailViewListener {

  private JournalDetailView view;
  private JournalService journalService;

  public JournalDetailPresenter(JournalService journalService) {
    this.journalService = journalService;
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

  public void setView(JournalDetailView view) {
    this.view = view;
    view.addListener(this);
  }
}
