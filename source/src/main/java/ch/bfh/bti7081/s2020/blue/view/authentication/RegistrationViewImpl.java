package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.domain.dto.RegisterDto;
import ch.bfh.bti7081.s2020.blue.presenter.RegistrationPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Register")
@Route(value = RegistrationViewImpl.ROUTE)
public class RegistrationViewImpl extends VerticalLayout implements RegistrationView {

  static final String ROUTE = "register";
  private final RegisterViewListener listener;

  private final Label infoText = new Label();

  public RegistrationViewImpl(BeanInjector beanInjector) {
    var binder = new Binder<>(RegisterDto.class);
    var registerDto = new RegisterDto();
    binder.setBean(registerDto);

    listener = new RegistrationPresenter(registerDto, this, beanInjector);

    var formLayout = new FormLayout();
    var registerTitle = new H2("Register");
    add(registerTitle);

    var givenNameField = new TextField();
    formLayout.addFormItem(givenNameField, "Given Name");
    binder.bind(givenNameField, RegisterDto::getGivenName, RegisterDto::setGivenName);

    var surnameField = new TextField();
    formLayout.addFormItem(surnameField, "Surname");
    binder.bind(surnameField, RegisterDto::getSurname, RegisterDto::setSurname);

    var username = new TextField();
    username.setValueChangeMode(ValueChangeMode.EAGER);
    formLayout.addFormItem(username, "Username");

    binder.forField(username)
        .withValidator(listener::isUsernameUnique, "Username is already registered.")
        .bind(RegisterDto::getUsername, RegisterDto::setUsername);

    var passwordField = new PasswordField();
    formLayout.addFormItem(passwordField, "Password");
    binder.bind(passwordField, RegisterDto::getPassword, RegisterDto::setPassword);

    var passwordRepeatField = new PasswordField();
    passwordRepeatField.setValueChangeMode(ValueChangeMode.EAGER);
    formLayout.addFormItem(passwordRepeatField, "Repeat password");
    binder
        .forField(passwordRepeatField)
        .withValidator(repeat -> repeat.equals(passwordField.getValue()), "Passwords do not match.")
        .bind(RegisterDto::getRepeatPassword, RegisterDto::setRepeatPassword);

    var emailField = new EmailField();
    emailField.setValueChangeMode(ValueChangeMode.EAGER);
    formLayout.addFormItem(emailField, "E-Mail");
    binder.forField(emailField).withValidator(new EmailValidator(
        "This doesn't look like a valid email address"))
        .withValidator(listener::isEmailUnique, "Email address is already registered.")
        .bind(RegisterDto::getEmail, RegisterDto::setEmail);

    infoText.addClassName("register-info-text");
    infoText.getStyle().set("color", "red");
    formLayout.add(infoText);
    formLayout.setColspan(infoText, 2);

    var save = new Button();
    save.setText("Save");
    save.addClickListener(e -> listener.saveButtonClick());
    save.setMaxWidth("800px");
    save.setWidthFull();

    add(formLayout);
    add(save);

    setSizeFull();
    formLayout.setMaxWidth("800px");
    setHorizontalComponentAlignment(Alignment.CENTER, registerTitle);
    setHorizontalComponentAlignment(Alignment.CENTER, formLayout);
    setHorizontalComponentAlignment(Alignment.CENTER, save);
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
