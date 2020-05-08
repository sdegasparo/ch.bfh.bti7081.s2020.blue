package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.view.header.HeaderView;

public class HeaderPresenter implements HeaderView.HeaderViewListener {

  private Object model;
  private HeaderView view;

  public HeaderPresenter(Object model, HeaderView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
  }
}