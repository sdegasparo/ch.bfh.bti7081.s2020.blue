package ch.bfh.bti7081.s2020.blue.view.therapist;

import ch.bfh.bti7081.s2020.blue.presenter.TherapistListPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("therapists")
public class TherapistListViewImpl extends VerticalLayout implements TherapistListView {

  private final TherapistViewListener listener;

  public TherapistListViewImpl() {
    this.listener = new TherapistListPresenter(new Object(), this);

    Label label = new Label("Therapist works!");
    add(label);
  }
}
