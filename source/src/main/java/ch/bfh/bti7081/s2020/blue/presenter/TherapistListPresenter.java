package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.therapist.TherapistListView;

public class TherapistListPresenter implements TherapistListView.TherapistViewListener {

  private final TherapistListView view;

  public TherapistListPresenter(TherapistListView view) {
    this.view = view;
  }

  @Override
  public void onInit() {
    view.display();
  }
}
