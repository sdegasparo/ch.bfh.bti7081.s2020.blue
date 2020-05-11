package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.journal.JournalDetailView;

public class JournalDetailPresenter implements JournalDetailView.JournalDetailViewListener {

  private Object model;
  private JournalDetailView view;

  public JournalDetailPresenter(Object model, JournalDetailView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }

  @Override
  public void saveButtonClick() {

  }

  @Override
  public void cancelButtonClick() {

  }
}
