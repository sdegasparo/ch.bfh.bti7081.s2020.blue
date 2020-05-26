package ch.bfh.bti7081.s2020.blue.view.layout.header;

import ch.bfh.bti7081.s2020.blue.presenter.HeaderPresenter;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class HeaderViewImpl extends HorizontalLayout implements HeaderView {

  private final HeaderViewListener listener;
  HorizontalLayout layout = new HorizontalLayout();

  public HeaderViewImpl() {
    listener = new HeaderPresenter(this);
    listener.onInit();

    HorizontalLayout titleLayout = new HorizontalLayout();
    titleLayout.setWidth("33.33%");
    HorizontalLayout navLayout = new HorizontalLayout();
    navLayout.setWidth("33.33%");
    HorizontalLayout userLayout = new HorizontalLayout();
    userLayout.setWidth("33.33%");

    Anchor title = new Anchor("home", "Social Anxiety Application");
    title.getStyle().set("color", "black");
    titleLayout.add(title);

    Anchor anchor1 = new Anchor("challenges", "Challenges");
    Anchor anchor2 = new Anchor("journal", "Journal");
    Anchor anchor3 = new Anchor("therapists", "Therapist");

    anchor1.getStyle().set("color", "black");
    anchor1.getStyle().set("margin", "0px");
    anchor2.getStyle().set("color", "black");
    anchor2.getStyle().set("margin", "0px");
    anchor3.getStyle().set("color", "black");
    anchor3.getStyle().set("margin", "0px");
    navLayout.add(anchor1, anchor2, anchor3);
    navLayout.setSpacing(true);
    navLayout.setJustifyContentMode(JustifyContentMode.AROUND);

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Label currentUser = new Label(
        authentication.getName());
    userLayout.add(currentUser);
    userLayout.setJustifyContentMode(JustifyContentMode.END);

    layout.add(titleLayout, navLayout, userLayout);
    layout.setWidth("100%");
    layout.getStyle().set("font-size", "1.5em");
    layout.getStyle().set("border-bottom", "3px solid #000000");
  }

  @Override
  public void display() {
    add(layout);
    setWidth("100%");
    setMargin(false);
    setPadding(false);
  }
}
