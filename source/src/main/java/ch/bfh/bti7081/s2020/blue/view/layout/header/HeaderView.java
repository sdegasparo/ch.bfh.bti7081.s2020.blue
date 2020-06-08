package ch.bfh.bti7081.s2020.blue.view.layout.header;

public interface HeaderView {

  void display();

  void navigateToLogout();

  void navigateToUserDetails();

  interface HeaderViewListener {

    void onInit();

    void onLogoutClick();

    void onEditProfileClick();
  }
}
