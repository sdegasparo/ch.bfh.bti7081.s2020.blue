package ch.bfh.bti7081.s2020.blue.view.authentication;

import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.presenter.UserDetailPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route("user")
@PageTitle("Profil")
@RouteAlias("profile")
public class UserDetailsViewImpl extends SocialAnxietyLayout implements UserDetailsView {

  private Label infoText;

  private UserDetailsListener listener;
  private Binder<UserDetailsDto> binder;

  public UserDetailsViewImpl(BeanInjector beanInjector) {
    super(beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    listener = new UserDetailPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  public void display(UserDetailsDto userDto) {
    binder = new Binder<>(UserDetailsDto.class);
    binder.setBean(userDto);
    var formLayout = new FormLayout();
    var title = new H2("Profil Bearbeiten");
    add(title);

    var givenNameField = new TextField();
    formLayout.addFormItem(givenNameField, "Vorname");
    binder.bind(givenNameField, UserDetailsDto::getGivenName, UserDetailsDto::setGivenName);

    var surnameField = new TextField();
    formLayout.addFormItem(surnameField, "Nachname");
    binder.bind(surnameField, UserDetailsDto::getSurname, UserDetailsDto::setSurname);

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
    binder.forField(emailField).withValidator(new EmailValidator(
        "Dies ist keine gültige E-Mail-Adresse."))
        .withValidator(listener::isEmailUnique, "Diese E-Mail-Adresse wird bereits verwendet.")
        .bind(UserDetailsDto::getEmail, UserDetailsDto::setEmail);
    infoText = new Label();
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
    setHorizontalComponentAlignment(Alignment.CENTER, title);
    setHorizontalComponentAlignment(Alignment.CENTER, formLayout);
    setHorizontalComponentAlignment(Alignment.CENTER, save);
  }

  @Override
  public UserDetailsDto getUserDetails() {
    return binder.getBean();
  }

  @Override
  public void showMessage(String message) {
    infoText.setText(message);
  }

  @Override
  public void navigateToLogin() {
    getUI().ifPresent(ui -> ui.navigate(LoginViewImpl.class));
  }
}
