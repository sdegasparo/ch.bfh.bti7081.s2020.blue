package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.ChallengeService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeDetailView;

public class ChallengeDetailPresenter implements ChallengeDetailView.ChallengeDetailViewListener {

  private final ChallengeDetailView view;
  private final ChallengeService challengeService;

  public ChallengeDetailPresenter(ChallengeDetailView view, BeanInjector beanInjector) {
    this.view = view;
    this.challengeService = beanInjector.get(ChallengeService.class);
  }

  @Override
  public void onInit(Long challengeId) {
    view.display(challengeService.findById(challengeId));
  }

  @Override
  public void onChallengeComplete(Long challengeId) {
    challengeService.completeChallenge(challengeId);

    view.afterChallengeCompleted();
  }
}
