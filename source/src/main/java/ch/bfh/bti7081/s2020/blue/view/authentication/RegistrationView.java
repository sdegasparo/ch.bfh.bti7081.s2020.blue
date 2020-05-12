package ch.bfh.bti7081.s2020.blue.view.authentication;

public interface RegistrationView {

  void navigate(String route);

  void showMessage(String message);

  interface RegisterViewListener {

    void saveButtonClick();

    boolean isUsernameUnique(String username);

    boolean isEmailUnique(String email);
  }
}
