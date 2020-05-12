package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.dto.RegisterDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.service.RegistrationService;
import ch.bfh.bti7081.s2020.blue.util.Beans;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView.RegisterViewListener;
import java.util.Collection;
import java.util.stream.Collectors;

public class RegistrationPresenter implements RegisterViewListener {

  private final RegisterDto model;
  private final RegistrationView view;
  private final RegistrationService registrationService;

  public RegistrationPresenter(RegisterDto model, RegistrationView view) {
    this.model = model;
    this.view = view;
    this.registrationService = Beans.get(RegistrationService.class);
  }

  @Override
  public void saveButtonClick() {
    view.showMessage("");
    Collection<ValidationError> errors = registrationService.register(model);
    if (errors.isEmpty()) {
      view.navigate("login");
    } else {
      view.showMessage(
          errors.stream()
              .map(ValidationError::getMessage)
              .collect(Collectors.joining(" ")));

    }
  }

  @Override
  public boolean isUsernameUnique(String username) {
    return registrationService.isUsernameUnique(username);
  }

  @Override
  public boolean isEmailUnique(String email) {
    return registrationService.isEmailUnique(email);
  }
}
