package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.dto.ChallengeDto;
import ch.bfh.bti7081.s2020.blue.presenter.ChallengesListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.HomeView;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;

@PageTitle("Challenges")
@Route(ChallengesListViewImpl.ROUTE)
public class ChallengesListViewImpl extends SocialAnxietyLayout implements ChallengesListView {

  static final String ROUTE = "challenges";

  private final ChallengesListViewListener listener;

  private Div challengeHolder;
  private Div content;

  public ChallengesListViewImpl(BeanInjector beanInjector) {
    super(beanInjector);
    listener = new ChallengesListPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    content = new Div();
    add(content);
  }

  @Override
  public void display(List<ChallengeDto> challenges) {
    content.add(new H2("Alle Herausforderungen"));

    for (ChallengeDto challenge : challenges) {
      Div div = new Div();

      div.getStyle().set("border", "1px solid black");
      div.getStyle().set("padding", "0.5em");
      div.getStyle().set("width", "100%");

      H3 title = new H3(challenge.getName());
      div.add(title);

      div.add(new Text(challenge.getContent()));
      div.add(new Html("<br />"));

      if (!challenge.getCompleted()) {
        Button acceptChallengeButton = new Button("Akzeptieren");
        acceptChallengeButton.addClickListener(event -> listener.onChallengeAccept(challenge.getId()));
        div.add(acceptChallengeButton);
      } else {
        Button challengeCompletedPlaceholderButton = new Button("Abgeschlossen");
        challengeCompletedPlaceholderButton.setEnabled(false);
        div.add(challengeCompletedPlaceholderButton);
      }

      content.add(div);
    }
  }

  @Override
  public void navigateToCurrentChallenges() {
    getUI().ifPresent(ui -> ui.navigate(HomeView.class));
  }
}
