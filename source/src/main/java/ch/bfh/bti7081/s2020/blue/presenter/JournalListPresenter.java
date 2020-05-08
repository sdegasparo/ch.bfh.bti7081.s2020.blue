package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView;

public class JournalListPresenter implements JournalListView.JournalListViewListener {

  private Object model;
  private JournalListView view;

  public JournalListPresenter(Object model, JournalListView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}
