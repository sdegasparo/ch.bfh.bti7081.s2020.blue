package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.authentication.LoginView;
import ch.bfh.bti7081.s2020.blue.view.authentication.LoginView.LoginViewListener;

public class LoginPresenter implements LoginViewListener {

  public LoginPresenter(Object model, LoginView view) {
    view.addListener(this);
  }
}
