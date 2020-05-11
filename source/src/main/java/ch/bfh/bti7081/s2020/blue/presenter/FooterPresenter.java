package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.footer.FooterView;

public class FooterPresenter implements FooterView.FooterViewListener {

  private Object model;
  private FooterView view;

  public FooterPresenter(Object model, FooterView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}
