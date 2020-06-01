package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.ChallengeService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.CurrentChallengesListView;
import ch.bfh.bti7081.s2020.blue.view.challenge.CurrentChallengesListView.CurrentChallengesListViewListener;

public class CurrentChallengesListPresenter implements CurrentChallengesListViewListener {

  private final CurrentChallengesListView view;
  private final ChallengeService challengeService;

  public CurrentChallengesListPresenter(CurrentChallengesListView view, BeanInjector beanInjector) {
    this.view = view;
    this.challengeService = beanInjector.get(ChallengeService.class);
  }

  @Override
  public void onInit() {
    view.display(challengeService.findAllAssignedToCurrentUser());
  }

  @Override
  public void onChallengeClick(Long id) {
    view.navigateToDetailView(id);
  }
}
