package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.ChallengeService;
import ch.bfh.bti7081.s2020.blue.util.Beans;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeDetailView;

public class ChallengeDetailPresenter implements ChallengeDetailView.ChallengeDetailViewListener {

  private final ChallengeDetailView view;
  private final ChallengeService challengeService;

  public ChallengeDetailPresenter(ChallengeDetailView view) {
    this.view = view;
    this.challengeService = Beans.get(ChallengeService.class);
  }

  @Override
  public void onInit(Long id) {
    view.display(challengeService.findById(id));
  }
}
