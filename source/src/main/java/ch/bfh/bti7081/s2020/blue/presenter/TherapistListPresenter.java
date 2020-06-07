package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.service.TherapistService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.therapist.TherapistListView;

public class TherapistListPresenter implements TherapistListView.TherapistViewListener {

  private final TherapistListView view;
  private final TherapistService therapistService;

  public TherapistListPresenter(TherapistListView view, BeanInjector beanInjector) {
    this.view = view;
    therapistService = beanInjector.get(TherapistService.class);
  }

  @Override
  public void onInit() {
    view.display(therapistService.findAll());
  }
}
