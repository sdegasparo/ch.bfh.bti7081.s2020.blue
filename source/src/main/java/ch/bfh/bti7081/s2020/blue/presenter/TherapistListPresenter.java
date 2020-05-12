package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.therapist.TherapistListView;

public class TherapistListPresenter implements TherapistListView.TherapistViewListener {

  private final Object model;
  private final TherapistListView view;

  public TherapistListPresenter(Object model, TherapistListView view) {
    this.model = model;
    this.view = view;
  }
}
