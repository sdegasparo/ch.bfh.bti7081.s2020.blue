package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeDetailView;

public class ChallengeDetailPresenter implements ChallengeDetailView.ChallengeDetailViewListener {

  private Object model;
  private ChallengeDetailView view;

  public ChallengeDetailPresenter(Object model, ChallengeDetailView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}
