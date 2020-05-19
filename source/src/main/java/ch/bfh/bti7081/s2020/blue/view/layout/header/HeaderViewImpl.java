package ch.bfh.bti7081.s2020.blue.view.layout.header;

import ch.bfh.bti7081.s2020.blue.presenter.HeaderPresenter;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HeaderViewImpl extends HorizontalLayout implements HeaderView {

  HorizontalLayout layout = new HorizontalLayout();

  private final HeaderViewListener listener;

  public HeaderViewImpl() {
    listener = new HeaderPresenter(this);
    listener.onInit();

    HorizontalLayout titleLayout = new HorizontalLayout();
    titleLayout.setWidth("33.33%");
    HorizontalLayout navLayout = new HorizontalLayout();
    navLayout.setWidth("33.33%");
    HorizontalLayout userLayout = new HorizontalLayout();
    userLayout.setWidth("33.33%");

    H1 title = new H1("Social Anxiety Application");
    titleLayout.add(title);
    titleLayout.setAlignItems(Alignment.END);

    /*
    Tab tab1 = new Tab(new Anchor("/", "Home"));
    Tab tab2 = new Tab(new Anchor("challenge", "Challenge"));
    Tab tab3 = new Tab(new Anchor("journal", "Journal"));
    Tab tab4 = new Tab(new Anchor("therapists", "Therapist"));
    Tabs tabs = new Tabs(tab1, tab2, tab3, tab4);*/

    Anchor anchor1 = new Anchor("challenge", "Challenge");
    Anchor anchor2 = new Anchor("journal", "Journal");
    Anchor anchor3 = new Anchor("therapists", "Therapist");
    navLayout.add(anchor1, anchor2, anchor3);
    navLayout.setAlignItems(Alignment.CENTER);
    navLayout.setSpacing(true);

    Text currentUser = new Text("Current User"); // TODO: Create Methode to getCurrentUser
    userLayout.add(currentUser);

    layout.add(titleLayout, navLayout, userLayout);
    layout.setWidth("100%");
    layout.setAlignItems(Alignment.BASELINE);

  }

  @Override
  public void display() {
    add(layout);
    setWidth("100%");
    setAlignItems(Alignment.BASELINE);
  }
}
