package ch.bfh.bti7081.s2020.blue;

import ch.bfh.bti7081.s2020.blue.domain.RegisterDto;
import ch.bfh.bti7081.s2020.blue.domain.RegisterService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = RegisterView.ROUTE)
@PageTitle("Register")
public class RegisterView extends FormLayout {

  public static final String ROUTE = "register";

  public RegisterView(@Autowired RegisterService service) {
    var binder = new Binder<>(RegisterDto.class);

    var registerDto = new RegisterDto();

    var givenNameField = new TextField();
    addFormItem(givenNameField, "Given Name");
    binder.bind(givenNameField, RegisterDto::getGivenName, RegisterDto::setGivenName);

    var surnameField = new TextField();
    addFormItem(surnameField, "Surname");
    binder.bind(surnameField, RegisterDto::getSurname, RegisterDto::setSurname);

    var username = new TextField();
    username.setPlaceholder("user1");
    addFormItem(username, "Username");
    binder.bind(username, RegisterDto::getUsername, RegisterDto::setUsername);

    var passwordField = new PasswordField();
    addFormItem(passwordField, "Password");
    binder.bind(passwordField, RegisterDto::getPassword, RegisterDto::setPassword);

    var passwordRepeatField = new PasswordField();
    addFormItem(passwordRepeatField, "Repeat password");
    binder
        .bind(passwordRepeatField, RegisterDto::getRepeatPassword, RegisterDto::setRepeatPassword);

    var emailField = new EmailField();
    addFormItem(emailField, "E-Mail");
    binder.forField(emailField).withValidator(new EmailValidator(
        "This doesn't look like a valid email address"))
        .bind(RegisterDto::getEmail, RegisterDto::setEmail);

    var save = new Button();
    save.setText("Save");
    var infoLabel = new Label();
    save.addClickListener(event -> {
      infoLabel.setText("");
      if (binder.writeBeanIfValid(registerDto)) {
        var errors = service.register(registerDto);
        if (errors.isEmpty()) {
          getUI().ifPresent(ui ->
              ui.navigate("/"));
        } else {
          infoLabel.setText(
              errors.stream()
                  .map(e -> e.getMessage())
                  .collect(Collectors.joining("\n "))
          );
        }

      } else {
        BinderValidationStatus<RegisterDto> validate = binder.validate();
        String errorText = validate.getFieldValidationStatuses()
            .stream().filter(BindingValidationStatus::isError)
            .map(BindingValidationStatus::getMessage)
            .map(Optional::get).distinct()
            .collect(Collectors.joining(", "));
        infoLabel.setText("There are errors: " + errorText);
      }
    });

    var reset = new Button();
    reset.setText("Reset");
    reset.addClickListener(event -> {
      // clear fields by setting null
      binder.readBean(null);
      infoLabel.setText("");
    });

    add(infoLabel);
    add(save);
    add(reset);
  }

}