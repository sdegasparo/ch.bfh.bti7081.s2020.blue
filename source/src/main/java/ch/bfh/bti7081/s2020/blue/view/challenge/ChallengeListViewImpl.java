package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.presenter.ChallengeListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import java.util.List;

public class ChallengeListViewImpl extends VerticalLayout implements ChallengeListView {

  private final ChallengeListViewListener listener;

  public ChallengeListViewImpl(BeanInjector beanInjector) {
    listener = new ChallengeListPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  public void display(List<Challenge> challenges) {
    for (Challenge challenge : challenges) {
      add(new RouterLink(challenge.getName(), ChallengeDetailViewImpl.class, challenge.getId()));
      add(new Text(challenge.getContent()));
    }

  }
}
