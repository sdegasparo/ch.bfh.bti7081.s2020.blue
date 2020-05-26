package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("home")
public class HomeView extends SocialAnxietyLayout {

  public HomeView(BeanInjector beanInjector) {
    super(beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    HorizontalLayout layout = new HorizontalLayout();
    layout.setWidth("100%");

    VerticalLayout challengeLayout = new VerticalLayout();
    challengeLayout.setWidth("50%");
    challengeLayout.add(new ChallengeListViewImpl(beanInjector));

    VerticalLayout journalLayout = new VerticalLayout();
    journalLayout.setWidth("50%");
    journalLayout.add(new JournalListViewImpl(beanInjector));

    layout.add(challengeLayout, journalLayout);
    add(layout);
  }
}
