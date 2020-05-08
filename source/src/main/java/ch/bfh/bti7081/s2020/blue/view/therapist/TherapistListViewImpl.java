package ch.bfh.bti7081.s2020.blue.view.therapist;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("therapists")
public class TherapistListViewImpl extends VerticalLayout implements TherapistListView {

  private List<TherapistViewListener> listeners = new ArrayList<>();

  public TherapistListViewImpl() {
    Label label = new Label("Therapist works!");
    add(label);
  }

  @Override
  public void addListener(TherapistViewListener listener) {
    listeners.add(listener);
  }
}
