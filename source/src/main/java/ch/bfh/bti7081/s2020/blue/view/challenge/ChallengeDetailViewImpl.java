package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.presenter.ChallengeDetailPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("challenge")
public class ChallengeDetailViewImpl extends VerticalLayout implements ChallengeDetailView,
    HasUrlParameter<String> {

  private final ChallengeDetailViewListener listener;

  public ChallengeDetailViewImpl() {
    this.listener = new ChallengeDetailPresenter(new Object(), this);

    Label label = new Label("ChallengeDetail works!");
    add(label);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, String id) {
    Label label = new Label("parameter " + id);
    add(label);
  }
}
