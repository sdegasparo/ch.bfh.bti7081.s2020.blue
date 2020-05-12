package ch.bfh.bti7081.s2020.blue.view.achievement;

import ch.bfh.bti7081.s2020.blue.presenter.AchievementListPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("achievements")
public class AchievementListViewImpl extends VerticalLayout implements AchievementListView {

  private final AchievementListViewListener listener;

  private final Label display = new Label("Achievement works!");

  public AchievementListViewImpl() {
    this.listener = new AchievementListPresenter(new Object(), this);

    add(display);
  }
}
