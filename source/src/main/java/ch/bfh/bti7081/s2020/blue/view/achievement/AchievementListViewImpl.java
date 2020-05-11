package ch.bfh.bti7081.s2020.blue.view.achievement;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("achievements")
public class AchievementListViewImpl extends VerticalLayout implements AchievementListView {

  private final List<AchievementListViewListener> listeners = new ArrayList<>();

  private final Label display = new Label("Achievement works!");

  public AchievementListViewImpl() {
    add(display);
  }

  @Override
  public void addListener(AchievementListViewListener listener) {
    listeners.add(listener);
  }
}
