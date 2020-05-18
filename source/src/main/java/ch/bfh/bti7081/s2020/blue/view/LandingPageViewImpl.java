package ch.bfh.bti7081.s2020.blue.view;

import ch.bfh.bti7081.s2020.blue.view.LandingPageView.LandingPageViewListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("welcome") // Should be index and MainView should have an other link, which is for users
public class LandingPageViewImpl extends VerticalLayout implements LandingPageViewListener {


  public LandingPageViewImpl() {
    Text title = new Text("Welcome");
    Text text = new Text("This is a Site about");
    add(title, text);

  }

}
