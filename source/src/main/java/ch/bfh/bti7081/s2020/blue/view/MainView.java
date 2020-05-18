package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.challenge.ChallengeListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.footer.FooterViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.header.HeaderViewImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout.Orientation;
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

    SplitLayout splitLayout = new SplitLayout(new ChallengeListViewImpl(beanInjector), new JournalListViewImpl(beanInjector));
    splitLayout.setOrientation(Orientation.HORIZONTAL);
    add(splitLayout);

    add(new FooterViewImpl());
  }
}
