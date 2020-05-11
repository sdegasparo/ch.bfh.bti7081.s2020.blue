package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.RegisterDto;
import ch.bfh.bti7081.s2020.blue.domain.RegisterService;
import ch.bfh.bti7081.s2020.blue.domain.ValidationError;
import ch.bfh.bti7081.s2020.blue.util.Beans;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegisterView;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegisterView.RegisterViewListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RegisterPresenter implements RegisterViewListener {

  private final RegisterDto model;
  private final RegisterView view;
  private final RegisterService registerService;

  public RegisterPresenter(RegisterDto model, RegisterView view) {
    this.model = model;
    this.view = view;
    this.registerService = Beans.get(RegisterService.class);
  }

  @Override
  public void saveButtonClick() {
    view.showMessage("");
    var errors = registerService.register(model);
    if (errors.isEmpty()) {
      view.navigate("");
    } else {
      view.showMessage(
          errors.stream()
              .map(ValidationError::getMessage)
              .collect(Collectors.joining(" ")));

    }
  }

  @Override
  public boolean isUsernameUnique(String username) {
    return registerService.isUsernameUnique(username);
  }

  @Override
  public boolean isEmailUnique(String email) {
    return registerService.isEmailUnique(email);
  }
}
