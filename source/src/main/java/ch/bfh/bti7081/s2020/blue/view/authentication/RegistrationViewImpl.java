package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.domain.dto.RegisterDto;
import ch.bfh.bti7081.s2020.blue.presenter.RegistrationPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = RegistrationViewImpl.ROUTE)
@PageTitle("Register")
public class RegistrationViewImpl extends FormLayout implements RegistrationView {

  static final String ROUTE = "register";
  private final RegisterViewListener listener;

  private final Label infoText = new Label();

  public RegistrationViewImpl(BeanInjector beanInjector) {
    var binder = new Binder<>(RegisterDto.class);
    var registerDto = new RegisterDto();
    binder.setBean(registerDto);

    listener = new RegistrationPresenter(registerDto, this, beanInjector);

    var givenNameField = new TextField();
    addFormItem(givenNameField, "Given Name");
    binder.bind(givenNameField, RegisterDto::getGivenName, RegisterDto::setGivenName);

    var surnameField = new TextField();
    addFormItem(surnameField, "Surname");
    binder.bind(surnameField, RegisterDto::getSurname, RegisterDto::setSurname);

    var username = new TextField();
    username.setPlaceholder("user1");
    username.setValueChangeMode(ValueChangeMode.EAGER);
    addFormItem(username, "Username");

    binder.forField(username)
        .withValidator(listener::isUsernameUnique, "Username is already registered.")
        .bind(RegisterDto::getUsername, RegisterDto::setUsername);

    var passwordField = new PasswordField();
    addFormItem(passwordField, "Password");
    binder.bind(passwordField, RegisterDto::getPassword, RegisterDto::setPassword);

    var passwordRepeatField = new PasswordField();
    passwordRepeatField.setValueChangeMode(ValueChangeMode.EAGER);
    addFormItem(passwordRepeatField, "Repeat password");
    binder
        .forField(passwordRepeatField)
        .withValidator(repeat -> repeat.equals(passwordField.getValue()), "Passwords do not match.")
        .bind(RegisterDto::getRepeatPassword, RegisterDto::setRepeatPassword);

    var emailField = new EmailField();
    emailField.setValueChangeMode(ValueChangeMode.EAGER);
    addFormItem(emailField, "E-Mail");
    binder.forField(emailField).withValidator(new EmailValidator(
        "This doesn't look like a valid email address"))
        .withValidator(listener::isEmailUnique, "Email address is already registered.")
        .bind(RegisterDto::getEmail, RegisterDto::setEmail);

    add(infoText);

    var save = new Button();
    save.setText("Save");
    save.addClickListener(e -> listener.saveButtonClick());
    add(save);
  }

  @Override
  public void navigate(String route) {
    getUI().ifPresent(ui ->
        ui.navigate(route));
  }

  @Override
  public void showMessage(String message) {
    infoText.setText(message);
  }
}
