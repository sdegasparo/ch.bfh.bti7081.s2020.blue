package ch.bfh.bti7081.s2020.blue.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = SecuredView.ROUTE)
public class SecuredView extends VerticalLayout {

  public static final String ROUTE = "secured";

  public SecuredView() {
    add(new TextField("High Secure"));
  }
}
