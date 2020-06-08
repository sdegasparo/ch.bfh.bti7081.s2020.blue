package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.layout.header.HeaderView;

public class HeaderPresenter implements HeaderView.HeaderViewListener {

  private final HeaderView view;

  public HeaderPresenter(HeaderView view) {
    this.view = view;
  }

  @Override
  public void onInit() {
    view.display();
  }

  @Override
  public void onLogoutClick() {
    view.navigateToLogout();
  }

  @Override
  public void onEditProfileClick() {
    view.navigateToUserDetails();
  }
}
