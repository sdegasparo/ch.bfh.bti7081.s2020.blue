package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.presenter.LoginPresenter;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Route(value = LoginViewImpl.ROUTE)
@PageTitle("Login")
public class LoginViewImpl extends VerticalLayout implements BeforeEnterObserver, LoginView {

  static final String ROUTE = "login";
  private List<LoginViewListener> listeners = new ArrayList<>();
  private LoginForm login = new LoginForm();

  public LoginViewImpl() {
    new LoginPresenter(null, this);
    login.setAction("login");
    this.add(login);
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) { //
    // inform the user about an authentication error
    // (yes, the API for resolving query parameters is annoying...)
    if (!event.getLocation().getQueryParameters().getParameters()
        .getOrDefault("error", Collections.emptyList()).isEmpty()) {
      login.setError(true); //
    }
  }

  @Override
  public void addListener(LoginViewListener listener) {
    listeners.add(listener);
  }
}