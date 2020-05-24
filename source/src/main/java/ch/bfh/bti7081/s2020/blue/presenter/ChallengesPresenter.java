package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.ChallengeService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengesView;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengesView.ChallengesViewListener;

public class ChallengesPresenter implements ChallengesViewListener {

  private final ChallengesView view;
  private final ChallengeService challengeService;

  public ChallengesPresenter(ChallengesView view, BeanInjector beanInjector) {
    this.view = view;
    this.challengeService = beanInjector.get(ChallengeService.class);
  }

  @Override
  public void onInit() {
    view.display(challengeService.findAllNotCompleted());
  }

  @Override
  public void onChallengeAccept(Long challengeId) {
    challengeService.assignToCurrentUser(challengeId);
  }
}
