package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.layout.footer.FooterView;

public class FooterPresenter implements FooterView.FooterViewListener {

  private final Object model;
  private final FooterView view;

  public FooterPresenter(Object model, FooterView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}
