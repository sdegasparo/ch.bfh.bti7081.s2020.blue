package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.view.NavigatableView;

public interface RegisterView extends NavigatableView {

  void showMessage(String message);

  interface RegisterViewListener {

    void saveButtonClick();

    boolean isUsernameUnique(String username);

    boolean isEmailUnique(String email);
  }
}
