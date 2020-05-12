package ch.bfh.bti7081.s2020.blue.view.layout.footer;

import ch.bfh.bti7081.s2020.blue.presenter.FooterPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FooterViewImpl extends HorizontalLayout implements FooterView {

  private final FooterViewListener listener;

  public FooterViewImpl() {
    listener = new FooterPresenter(this);
    listener.onInit();
  }

  @Override
  public void display() {
    add(new Label("Footer works!"));
  }
}
