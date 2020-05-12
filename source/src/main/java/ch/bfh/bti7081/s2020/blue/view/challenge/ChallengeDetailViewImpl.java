package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.presenter.ChallengeDetailPresenter;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("challenge")
public class ChallengeDetailViewImpl extends VerticalLayout implements ChallengeDetailView, HasUrlParameter<Long> {

  private final ChallengeDetailViewListener listener;

  public ChallengeDetailViewImpl() {
    listener = new ChallengeDetailPresenter(this);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, Long id) {
    listener.onInit(id);
  }

  @Override
  public void display(Challenge challenge) {
    Text name = new Text(challenge.getName());
    Text content = new Text(challenge.getContent());
    add(name, content);
  }
}
