package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.presenter.AchievementListPresenter;
import ch.bfh.bti7081.s2020.blue.presenter.ChallengeListPresenter;
import ch.bfh.bti7081.s2020.blue.presenter.FooterPresenter;
import ch.bfh.bti7081.s2020.blue.presenter.HeaderPresenter;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import ch.bfh.bti7081.s2020.blue.presenter.TherapistListPresenter;
import ch.bfh.bti7081.s2020.blue.view.achievement.AchievementListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.footer.FooterViewImpl;
import ch.bfh.bti7081.s2020.blue.view.header.HeaderViewImpl;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListViewImpl;
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

  public MainView(JournalListPresenter journalListPresenter) {
    Object o = new Object();

    HeaderViewImpl headerView = new HeaderViewImpl();
    new HeaderPresenter(o, headerView);
    add(headerView);

    JournalListViewImpl journalListView = new JournalListViewImpl();
    journalListPresenter.setView(journalListView);
    add(journalListView);

    ChallengeListViewImpl challengeListView = new ChallengeListViewImpl();
    new ChallengeListPresenter(o, challengeListView);
    add(challengeListView);

    AchievementListViewImpl achievementListView = new AchievementListViewImpl();
    new AchievementListPresenter(o, achievementListView);
    add(achievementListView);

    TherapistListViewImpl therapistListView = new TherapistListViewImpl();
    new TherapistListPresenter(o, therapistListView);
    add(therapistListView);

    FooterViewImpl footerView = new FooterViewImpl();
    new FooterPresenter(o, footerView);
    add(footerView);
  }
}
