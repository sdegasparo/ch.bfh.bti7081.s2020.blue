package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;

public interface UserDetailsView {

  void navigateToLogin();

  void display(UserDetailsDto userDto);

  UserDetailsDto getUserDetails();

  void showMessage(String message);

  interface UserDetailsListener {

    void saveButtonClick();

    boolean isEmailUnique(String email);

    void onInit();
  }
}
