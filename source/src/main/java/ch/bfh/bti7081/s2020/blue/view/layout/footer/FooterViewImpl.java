package ch.bfh.bti7081.s2020.blue.view.layout.footer;

import ch.bfh.bti7081.s2020.blue.presenter.FooterPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FooterViewImpl extends HorizontalLayout implements FooterView {

  private final FooterViewListener listener;

  public FooterViewImpl() {
    listener = new FooterPresenter(this);
    listener.onInit();
    setMaxWidth("800px");
  }

  @Override
  public void display() {

    var copyrightLabel = new Label("© by team blue");
    copyrightLabel.getStyle().set("font-weight", "bolder");
    add(copyrightLabel);
  }
}
