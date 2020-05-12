package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.layout.footer.FooterView;

public class FooterPresenter implements FooterView.FooterViewListener {

  private final FooterView view;

  public FooterPresenter(FooterView view) {
    this.view = view;
  }

  @Override
  public void onInit() {
    view.display();
  }
}
