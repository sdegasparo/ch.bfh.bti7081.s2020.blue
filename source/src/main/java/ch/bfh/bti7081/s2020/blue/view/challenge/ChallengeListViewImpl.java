package ch.bfh.bti7081.s2020.blue.view.challenge;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import java.util.ArrayList;
import java.util.List;

public class ChallengeListViewImpl extends VerticalLayout implements ChallengeListView {

  private final List<ChallengeListViewListener> listeners = new ArrayList<>();

  public ChallengeListViewImpl() {
    Label label = new Label("Challenge works!");
    add(label);

    RouterLink routerLink = new RouterLink("challenge", ChallengeDetailViewImpl.class,
        "EnterChallengeIdHere");
    add(routerLink);
  }

  @Override
  public void addListener(ChallengeListViewListener listener) {
    listeners.add(listener);
  }
}
