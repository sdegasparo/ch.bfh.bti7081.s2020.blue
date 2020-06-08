package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.service.UserDetailsService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView.RegisterViewListener;
import java.util.List;
import java.util.stream.Collectors;

public class RegistrationPresenter implements RegisterViewListener {

  private final RegistrationView view;
  private final UserDetailsDto model;
  private final UserDetailsService userDetailsService;

  public RegistrationPresenter(RegistrationView view, UserDetailsDto model, BeanInjector beanInjector) {
    this.view = view;
    this.model = model;
    this.userDetailsService = beanInjector.get(UserDetailsService.class);
  }

  @Override
  public void saveButtonClick() {
    view.showMessage("");
    List<ValidationError> errors = userDetailsService.register(model);
    if (errors.isEmpty()) {
      view.navigateToLogin();
    } else {
      view.showMessage(errors.stream()
          .map(ValidationError::getMessage)
          .collect(Collectors.joining(" ")));
    }
  }

  @Override
  public boolean isUsernameUnique(String username) {
    return userDetailsService.isUsernameUnique(username);
  }

  @Override
  public boolean isEmailUnique(String email) {
    return userDetailsService.isEmailUnique(email);
  }
}
