package ch.bfh.bti7081.s2020.blue.view.therapist;

import ch.bfh.bti7081.s2020.blue.presenter.TherapistListPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("therapists")
public class TherapistListViewImpl extends VerticalLayout implements TherapistListView {

  private final TherapistViewListener listener;

  public TherapistListViewImpl() {
    listener = new TherapistListPresenter(this);
    listener.onInit();
  }

  @Override
  public void display() {
    add(new Label("Therapist works!"));
  }
}
