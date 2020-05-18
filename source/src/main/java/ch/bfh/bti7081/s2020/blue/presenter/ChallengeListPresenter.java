package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.ChallengeService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListView;

public class ChallengeListPresenter implements ChallengeListView.ChallengeListViewListener {

  private final ChallengeListView view;
  private final ChallengeService challengeService;

  public ChallengeListPresenter(ChallengeListView view, BeanInjector beanInjector) {
    this.view = view;
    this.challengeService = beanInjector.get(ChallengeService.class);
  }

  @Override
  public void onInit() {
    view.display(challengeService.findAll());
  }

  @Override
  public void listItemClick(Long id) {
    view.navigateToDetailView(id);
  }
}
