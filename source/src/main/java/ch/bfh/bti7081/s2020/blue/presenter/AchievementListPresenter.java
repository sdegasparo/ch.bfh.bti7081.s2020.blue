package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.achievement.AchievementListView;

public class AchievementListPresenter implements AchievementListView.AchievementListViewListener {

  private Object model;
  private AchievementListView view;

  public AchievementListPresenter(Object model, AchievementListView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}
