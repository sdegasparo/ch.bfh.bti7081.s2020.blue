package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.ChallengeService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengesListView;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengesListView.ChallengesListViewListener;

public class ChallengesPresenter implements ChallengesListViewListener {

  private final ChallengesListView view;
  private final ChallengeService challengeService;

  public ChallengesPresenter(ChallengesListView view, BeanInjector beanInjector) {
    this.view = view;
    this.challengeService = beanInjector.get(ChallengeService.class);
  }

  @Override
  public void onInit() {
    view.display(challengeService.findAll());
  }

  @Override
  public void onChallengeAccept(Long challengeId) {
    challengeService.assignToCurrentUser(challengeId);
  }
}
