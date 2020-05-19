package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.view.LandingPageView.LandingPageViewListener;
import ch.bfh.bti7081.s2020.blue.view.authentication.LoginViewImpl;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("welcome") // Should be index and MainView should have an other link, which is for users
public class LandingPageViewImpl extends VerticalLayout implements LandingPageViewListener {


  public LandingPageViewImpl() {
    H1 title = new H1("Willkommen zur soziale Phobie App");

    HorizontalLayout container = new HorizontalLayout();

    VerticalLayout leftLayout = new VerticalLayout();
    leftLayout.setMaxWidth("50%");
    leftLayout.setPadding(true);
    leftLayout.setSpacing(true);
    VerticalLayout rightLayout = new VerticalLayout();
    rightLayout.setMaxWidth("50%");

    container.add(leftLayout, rightLayout);

    Text introduction = new Text(// Möglicherweise sollte der Text in der DB sein
        "Eine soziale Phobie ist eine Form der Angststörung und zeichnet sich durch eine anhaltende und unangemessen starke Angst vor sozialen Situationen aus, die weit über eine normale Schüchternheit oder Lampenfieber hinausgeht. Personen mit einer Sozialphobie befürchten, sich vor anderen zu blamieren, sich peinlich zu verhalten oder abgelehnt zu werden. Die Ursachen sind bisher nicht vollständig geklärt. Vermutlich spielen verschiedene Auslöser eine Rolle. ");
    leftLayout.add(introduction);

    HorizontalLayout signUpLayout = new HorizontalLayout();
    Text signUpText = new Text("Haben Sie noch kein Benutzerkonto?");
    Anchor signUpAnchor = new Anchor("/register", "Registrieren");

    signUpLayout.add(signUpText, signUpAnchor);

    LoginViewImpl loginView = new LoginViewImpl();
    loginView.setAlignItems(Alignment.CENTER);

    rightLayout.add(loginView, signUpLayout);
    rightLayout.setAlignItems(Alignment.CENTER);

    setAlignItems(Alignment.CENTER);
    setSizeFull();
    add(title, container);
  }

}
