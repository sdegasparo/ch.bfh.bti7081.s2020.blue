package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.presenter.ChallengeListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.List;

public class ChallengeListViewImpl extends VerticalLayout implements ChallengeListView {

  private final ChallengeListViewListener listener;

  public ChallengeListViewImpl(BeanInjector beanInjector) {
    listener = new ChallengeListPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  public void display(List<Challenge> challenges) {
    add(new H2("Meine aktuellen Herausforderungen"));

    for (Challenge challenge : challenges) {
      Div div = new Div();
      div.getStyle().set("border", "1px solid black");
      div.getStyle().set("padding", "0.5em");
      div.getStyle().set("width", "100%");

      H3 title = new H3(challenge.getName());
      title.getStyle().set("margin", "0"); // TODO should be in global styles
      div.add(title);

      div.add(new Text(challenge.getContent()));

      Button detailButton = new Button("Detail");
      detailButton.addClickListener(event -> listener.onChallengeClick(challenge.getId()));
      div.add(detailButton);

      add(div);
    }

  }

  @Override
  public void navigateToDetailView(Long id) {
    getUI().ifPresent(ui -> ui.navigate(ChallengeDetailViewImpl.class, id));
  }

}
