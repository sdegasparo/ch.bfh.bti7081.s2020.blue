package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListView;

public class ChallengeListPresenter implements ChallengeListView.ChallengeListViewListener {

  private Object model;
  private ChallengeListView view;

  public ChallengeListPresenter(Object model, ChallengeListView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}