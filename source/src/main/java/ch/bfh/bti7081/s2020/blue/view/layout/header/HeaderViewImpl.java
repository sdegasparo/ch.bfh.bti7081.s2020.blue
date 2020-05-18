package ch.bfh.bti7081.s2020.blue.view.layout.header;

import ch.bfh.bti7081.s2020.blue.presenter.HeaderPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HeaderViewImpl extends HorizontalLayout implements HeaderView {

  private final HeaderViewListener listener;

  public HeaderViewImpl() {
    listener = new HeaderPresenter(this);
    listener.onInit();
  }

  @Override
  public void display() {
    add(new Label("Header works!"));
  }
}
