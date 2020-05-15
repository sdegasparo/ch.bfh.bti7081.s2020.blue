package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.achievement.AchievementListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.footer.FooterViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.header.HeaderViewImpl;
import ch.bfh.bti7081.s2020.blue.view.therapist.TherapistListViewImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route
@PWA(name = "Social Anxiety Application",
    shortName = "Social Anxiety App",
    description = "This is an application to help people with social anxiety.",
    enableInstallPrompt = false)
public class MainView extends VerticalLayout {

  public MainView(BeanInjector beanInjector) {
    add(new HeaderViewImpl());

    add(new JournalListViewImpl(beanInjector));

    add(new ChallengeListViewImpl(beanInjector));

    add(new AchievementListViewImpl());

    add(new TherapistListViewImpl());

    add(new FooterViewImpl());
  }
}
