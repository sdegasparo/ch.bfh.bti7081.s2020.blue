package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.presenter.ChallengeListPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class ChallengeListViewImpl extends VerticalLayout implements ChallengeListView {

  private final ChallengeListViewListener listener;

  public ChallengeListViewImpl() {
    this.listener = new ChallengeListPresenter(new Object(), this);

    Label label = new Label("Challenge works!");
    add(label);

    RouterLink routerLink = new RouterLink("challenge", ChallengeDetailViewImpl.class,
        "EnterChallengeIdHere");
    add(routerLink);
  }
}
