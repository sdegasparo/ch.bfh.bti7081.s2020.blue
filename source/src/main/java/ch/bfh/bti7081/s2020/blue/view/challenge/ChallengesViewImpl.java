package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.dto.ChallengeDto;
import ch.bfh.bti7081.s2020.blue.presenter.ChallengesPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;

@PageTitle("Challenges")
@Route(ChallengesViewImpl.ROUTE)
public class ChallengesViewImpl extends SocialAnxietyLayout implements ChallengesView {

  static final String ROUTE = "challenges";

  private final ChallengesViewListener listener;

  Div challengeHolder;

  public ChallengesViewImpl(BeanInjector beanInjector) {
    super(beanInjector);

    listener = new ChallengesPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    this.challengeHolder = new Div();

    add(new H2("Alle Herausforderungen"));
    add(challengeHolder);
  }

  @Override
  public void display(List<ChallengeDto> challenges) {
    for (ChallengeDto challenge : challenges) {
      Div div = new Div();

      if (challenge.getCompleted()) {
        div.getStyle().set("border", "1px solid green");
      } else {
        div.getStyle().set("border", "1px solid black");
      }

      div.getStyle().set("padding", "0.5em");
      div.getStyle().set("width", "100%");

      H3 title = new H3(challenge.getName());
      title.getStyle().set("margin", "0"); // TODO should be in global styles
      div.add(title);

      div.add(new Text(challenge.getContent()));

      Button acceptChallengeButton = new Button("Akzeptieren");
      acceptChallengeButton
          .addClickListener(event -> listener.onChallengeAccept(challenge.getId()));
      div.add(acceptChallengeButton);

      challengeHolder.add(div);
    }
  }
}
