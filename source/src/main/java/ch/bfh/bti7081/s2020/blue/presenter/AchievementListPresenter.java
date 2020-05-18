package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.achievement.AchievementListView;

public class AchievementListPresenter implements AchievementListView.AchievementListViewListener {

  private final AchievementListView view;

  public AchievementListPresenter(AchievementListView view) {
    this.view = view;
  }

  @Override
  public void onInit() {
    view.display();
  }
}
