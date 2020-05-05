package ch.bfh.bti7081.s2020.blue;

import ch.bfh.bti7081.s2020.blue.model.User;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Route(value = RegisterView.ROUTE)
@PageTitle("Register")
public class RegisterView extends FormLayout {

  public static final String ROUTE = "register";

  public RegisterView() {
    Binder<User> binder = new Binder<>(User.class);
    User user = new User("", "");
    binder.readBean(user);
    Button save = new Button();
    save.setText("Save");
    Label infoLabel = new Label();
    save.addClickListener(event -> {
      if (binder.writeBeanIfValid(user)) {
        infoLabel.setText("Saved bean values: " + user.getUsername());
      } else {
        BinderValidationStatus<User> validate = binder.validate();
        String errorText = validate.getFieldValidationStatuses()
            .stream().filter(BindingValidationStatus::isError)
            .map(BindingValidationStatus::getMessage)
            .map(Optional::get).distinct()
            .collect(Collectors.joining(", "));
        infoLabel.setText("There are errors: " + errorText);
      }
    });
    Button reset = new Button();
    reset.setText("Reset");
    reset.addClickListener(event -> {
      // clear fields by setting null
      binder.readBean(null);
      infoLabel.setText("");
    });


    TextField username = new TextField();
    username.setPlaceholder("user1");
    addFormItem(username, "Username");
    binder.bind(username, User::getUsername, User::setUsername);
    addFormItem(new PasswordField(), "Password");
    binder.bind(username, User::getUsername, User::setUsername);
    addFormItem(new PasswordField(), "Password repeat");

    addFormItem(new EmailField(), "E-Mail");
    add(infoLabel);
    add(save);
    add(reset);
  }

}