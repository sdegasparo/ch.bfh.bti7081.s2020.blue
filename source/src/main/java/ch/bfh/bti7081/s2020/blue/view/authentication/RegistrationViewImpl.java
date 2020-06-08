package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.presenter.RegistrationPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.button.Button;
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
    var binder = new Binder<>(UserDetailsDto.class);
    var registerDto = new UserDetailsDto();
    binder.setBean(registerDto);

    listener = new RegistrationPresenter(this, registerDto, beanInjector);

    var formLayout = new FormLayout();
    var registerTitle = new H2("Registrieren");
    add(registerTitle);

    var givenNameField = new TextField();
    formLayout.addFormItem(givenNameField, "Vorname");
    binder.bind(givenNameField, UserDetailsDto::getGivenName, UserDetailsDto::setGivenName);

    var surnameField = new TextField();
    formLayout.addFormItem(surnameField, "Nachname");
    binder.bind(surnameField, UserDetailsDto::getSurname, UserDetailsDto::setSurname);

    var username = new TextField();
    username.setValueChangeMode(ValueChangeMode.EAGER);
    formLayout.addFormItem(username, "Benutzername");

    binder.forField(username)
        .withValidator(listener::isUsernameUnique, "Dieser Benutzername wird bereits verwendet.")
        .bind(UserDetailsDto::getUsername, UserDetailsDto::setUsername);

    var passwordField = new PasswordField();
    formLayout.addFormItem(passwordField, "Passwort");
    binder.bind(passwordField, UserDetailsDto::getPassword, UserDetailsDto::setPassword);

    var passwordRepeatField = new PasswordField();
    passwordRepeatField.setValueChangeMode(ValueChangeMode.EAGER);
    formLayout.addFormItem(passwordRepeatField, "Passwort wiederholen");
    binder.forField(passwordRepeatField)
        .withValidator(repeat -> repeat.equals(passwordField.getValue()), "Passwörter stimmen nicht überein.")
        .bind(UserDetailsDto::getRepeatPassword, UserDetailsDto::setRepeatPassword);

    var emailField = new EmailField();
    emailField.setValueChangeMode(ValueChangeMode.EAGER);
    formLayout.addFormItem(emailField, "E-Mail");
    binder.forField(emailField)
        .withValidator(new EmailValidator("Dies ist keine gültige E-Mail-Adresse."))
        .withValidator(listener::isEmailUnique, "Diese E-Mail-Adresse wird bereits verwendet.")
        .bind(UserDetailsDto::getEmail, UserDetailsDto::setEmail);

    infoText.addClassName("register-info-text");
    infoText.getStyle().set("color", "red");
    formLayout.add(infoText);
    formLayout.setColspan(infoText, 2);

    var save = new Button();
    save.setText("Registrieren");
    save.addClickListener(event -> listener.saveButtonClick());
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
  public void navigateToLogin() {
    getUI().ifPresent(ui -> ui.navigate(LoginViewImpl.class));
  }

  @Override
  public void showMessage(String message) {
    infoText.setText(message);
  }
}
