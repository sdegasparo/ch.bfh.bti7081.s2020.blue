package ch.bfh.bti7081.s2020.blue;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = SecuredView.ROUTE)
@PageTitle("Login")
public class SecuredView extends VerticalLayout {
    public static final String ROUTE = "secured";
    public SecuredView() {
        add(new TextField("High Secure"));
    }

}
