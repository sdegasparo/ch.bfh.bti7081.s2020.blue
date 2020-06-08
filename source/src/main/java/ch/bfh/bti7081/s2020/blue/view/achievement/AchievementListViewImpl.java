package ch.bfh.bti7081.s2020.blue.view.achievement;

import ch.bfh.bti7081.s2020.blue.presenter.AchievementListPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("achievements")
public class AchievementListViewImpl extends VerticalLayout implements AchievementListView {

  public AchievementListViewImpl() {
    AchievementListViewListener listener = new AchievementListPresenter(this);
    listener.onInit();
  }

  @Override
  public void display() {
    add(new Label("Achievement works!"));
  }
}
