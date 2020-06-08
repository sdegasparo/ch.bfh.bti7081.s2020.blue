package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.service.UserDetailsService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.authentication.UserDetailsView;
import ch.bfh.bti7081.s2020.blue.view.authentication.UserDetailsView.UserDetailsListener;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDetailPresenter implements UserDetailsListener {

  private final UserDetailsView view;
  private final UserDetailsService userDetailsService;

  public UserDetailPresenter(UserDetailsView view, BeanInjector beanInjector) {
    this.view = view;
    this.userDetailsService = beanInjector.get(UserDetailsService.class);
  }

  @Override
  public void onInit() {
    Optional<UserDetailsDto> dto = userDetailsService.getCurrentUserDetails();
    if (dto.isPresent()) {
      view.display(dto.get());
    } else {
      view.navigateToLogin();
    }
  }

  @Override
  public void saveButtonClick() {
    view.showMessage("");
    Collection<ValidationError> errors = userDetailsService.updateCurrentUserDetails(view.getUserDetails());
    view.showMessage(errors.stream()
        .map(ValidationError::getMessage)
        .collect(Collectors.joining(" ")));
  }

  @Override
  public boolean isEmailUnique(String email) {
    return userDetailsService.isEmailUnique(email);
  }
}
