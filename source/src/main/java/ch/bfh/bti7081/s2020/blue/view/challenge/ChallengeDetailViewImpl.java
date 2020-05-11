package ch.bfh.bti7081.s2020.blue.view.challenge;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("challenge")
public class ChallengeDetailViewImpl extends VerticalLayout implements ChallengeDetailView, HasUrlParameter<String> {

  private List<ChallengeDetailViewListener> listeners = new ArrayList<>();

  public ChallengeDetailViewImpl() {
    Label label = new Label("ChallengeDetail works!");
    add(label);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, String id) {
    Label label = new Label("parameter " + id);
    add(label);
  }

  @Override
  public void addListener(ChallengeDetailViewListener listener) {
    listeners.add(listener);
  }
}
