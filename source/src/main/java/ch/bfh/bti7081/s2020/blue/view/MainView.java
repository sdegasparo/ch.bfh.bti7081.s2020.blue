package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.CurrentChallengesListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("home")
@PWA(name = "Social Anxiety Application",
    shortName = "Social Anxiety App",
    description = "This is an application to help people with social anxiety.",
    enableInstallPrompt = false)
public class MainView extends SocialAnxietyLayout {

  public MainView(BeanInjector beanInjector) {
    super(beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    HorizontalLayout layout = new HorizontalLayout();
    layout.setWidth("100%");

    VerticalLayout challengeLayout = new VerticalLayout();
    challengeLayout.setWidth("50%");
    challengeLayout.add(new CurrentChallengesListViewImpl(beanInjector));

    VerticalLayout journalLayout = new VerticalLayout();
    journalLayout.setWidth("50%");
    journalLayout.add(new JournalListViewImpl(beanInjector));

    layout.add(challengeLayout, journalLayout);
    layout.getStyle().set("flex-grow", "1");
    add(layout);
  }
}
