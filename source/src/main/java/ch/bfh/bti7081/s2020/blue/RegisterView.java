package ch.bfh.bti7081.s2020.blue;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.Collections;

@Tag("sa-login-view")
@Route(value = RegisterView.ROUTE)
@PageTitle("Login")
public class RegisterView extends VerticalLayout implements BeforeEnterObserver {
  public static final String ROUTE = "login";
  private LoginForm login = new LoginForm();

  public RegisterView(){
    login.setAction("login");
    getElement().appendChild(login.getElement());
  }
  @Override
  public void beforeEnter(BeforeEnterEvent event) { //
    // inform the user about an authentication error
    // (yes, the API for resolving query parameters is annoying...)
    if(!event.getLocation().getQueryParameters().getParameters().getOrDefault("error", Collections.emptyList()).isEmpty()) {
      login.setError(true); //
    }
  }
}