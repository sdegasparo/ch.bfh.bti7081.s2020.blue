package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.achievement.AchievementListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import ch.bfh.bti7081.s2020.blue.view.therapist.TherapistListViewImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route
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
    VerticalLayout verticalLayout = new VerticalLayout();
    verticalLayout.add(new JournalListViewImpl(beanInjector));
    verticalLayout.add(new ChallengeListViewImpl(beanInjector));
    verticalLayout.add(new AchievementListViewImpl());
    verticalLayout.add(new TherapistListViewImpl());
    add(verticalLayout);
  }
}
