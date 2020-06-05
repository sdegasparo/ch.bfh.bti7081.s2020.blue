package ch.bfh.bti7081.s2020.blue.view.layout.header;

import ch.bfh.bti7081.s2020.blue.presenter.HeaderPresenter;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
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

    Icon icon1 = new Icon(VaadinIcon.GAMEPAD);
    Icon icon2 = new Icon(VaadinIcon.CLIPBOARD_TEXT);
    Icon icon3 = new Icon(VaadinIcon.DOCTOR);
    String color = "#000000";
    String size = "2em";
    icon1.setColor(color);
    icon1.setSize(size);
    icon2.setColor(color);
    icon2.setSize(size);
    icon3.setColor(color);
    icon3.setSize(size);

    Anchor anchor1 = new Anchor("challenges", icon1);
    Anchor anchor2 = new Anchor("journal", icon2);
    Anchor anchor3 = new Anchor("therapists", icon3);

    navLayout.add(anchor1, anchor2, anchor3);
    navLayout.setSpacing(true);
    navLayout.setJustifyContentMode(JustifyContentMode.AROUND);

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Label currentUser = new Label(
        authentication.getName());
    Icon userIcon = new Icon(VaadinIcon.USER);
    userIcon.setColor(color);
    userIcon.getStyle().set("width", "1em")
        .set("height", "2em");
    userLayout.add(userIcon, currentUser);
    userLayout.setJustifyContentMode(JustifyContentMode.END);

    layout.add(titleLayout, navLayout, userLayout);
    layout.setWidth("100%");
    layout.getStyle().set("font-size", "1.5em")
        .set("border-bottom", "3px solid #000000")
        .set("padding-bottom", "0.5em");
  }

  @Override
  public void display() {
    add(layout);
    setWidth("100%");
    setMargin(false);
    setPadding(false);
  }
}
