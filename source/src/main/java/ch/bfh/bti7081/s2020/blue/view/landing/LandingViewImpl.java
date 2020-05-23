package ch.bfh.bti7081.s2020.blue.view.landing;

import ch.bfh.bti7081.s2020.blue.view.authentication.LoginViewImpl;
import ch.bfh.bti7081.s2020.blue.view.landing.LandingView.LandingPageViewListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class LandingViewImpl extends VerticalLayout implements LandingPageViewListener {


  public LandingViewImpl() {
    H1 title = new H1("Willkommen zur soziale Phobie App");

    HorizontalLayout container = new HorizontalLayout();

    VerticalLayout leftLayout = new VerticalLayout();
    leftLayout.setWidth("50%");
    leftLayout.setPadding(true);
    leftLayout.setSpacing(true);
    leftLayout.getStyle().set("padding", "70px");
    VerticalLayout rightLayout = new VerticalLayout();
    rightLayout.setWidth("50%");

    container.add(leftLayout, rightLayout);

    H3 introductiontitle = new H3("Was ist soziale Phobie?");
    Text introduction = new Text(
        "Eine soziale Phobie ist eine Form der Angststörung und zeichnet sich durch eine anhaltende und unangemessen starke Angst vor sozialen Situationen aus, die weit über eine normale Schüchternheit oder Lampenfieber hinausgeht. Personen mit einer Sozialphobie befürchten, sich vor anderen zu blamieren, sich peinlich zu verhalten oder abgelehnt zu werden. Die Ursachen sind bisher nicht vollständig geklärt. Vermutlich spielen verschiedene Auslöser eine Rolle. \n"
            + "\n"
            + "Mit unserer Applikation können Sie spielerisch, Ihrer soziale Phobie den Kampf ansagen. Versuche deine Angst zu überwinden bei den Challenges und verdiene deine Rewards.");
    H3 introductionTitle = new H3("Funktionen:");
    ListItem li1 = new ListItem("Challenges bestreiten");
    ListItem li2 = new ListItem("Rewards erhalten");
    ListItem li3 = new ListItem("Journaleintrag erstellen und bearbeiten");
    ListItem li4 = new ListItem("Therapisten finden");

    leftLayout.add(introductiontitle, introduction, introductionTitle, li1, li2, li3, li4);

    HorizontalLayout signUpLayout = new HorizontalLayout();
    Text signUpText = new Text("Haben Sie noch kein Benutzerkonto?");
    Anchor signUpAnchor = new Anchor("/register", "Registrieren");

    signUpLayout.add(signUpText, signUpAnchor);

    rightLayout.add(new LoginViewImpl(), signUpLayout);
    rightLayout.setAlignItems(Alignment.CENTER);

    setAlignItems(Alignment.CENTER);
    setSizeFull();
    add(title, container);
  }

}
