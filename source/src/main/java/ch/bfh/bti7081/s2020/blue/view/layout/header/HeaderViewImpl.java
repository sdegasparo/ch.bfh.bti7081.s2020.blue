package ch.bfh.bti7081.s2020.blue.view.layout.header;

import ch.bfh.bti7081.s2020.blue.presenter.HeaderPresenter;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class HeaderViewImpl extends HorizontalLayout implements HeaderView {

  HorizontalLayout layout = new HorizontalLayout();

  private final HeaderViewListener listener;

  public HeaderViewImpl() {
    listener = new HeaderPresenter(this);
    listener.onInit();

    H1 title = new H1("Social Anxiety Application");

    Tab tab1 = new Tab(new Anchor("/", "Home"));
    Tab tab2 = new Tab(new Anchor("challenge", "Challenge"));
    Tab tab3 = new Tab(new Anchor("journal", "Journal"));
    Tab tab4 = new Tab(new Anchor("therapists", "Therapist"));
    Tabs tabs = new Tabs(tab1, tab2, tab3, tab4);

    Text currentUser = new Text("Current User"); // TODO: Create Methode to getCurrentUser

    layout.add(title, tabs, currentUser);

  }

  @Override
  public void display() {
    add(layout);
  }
}
