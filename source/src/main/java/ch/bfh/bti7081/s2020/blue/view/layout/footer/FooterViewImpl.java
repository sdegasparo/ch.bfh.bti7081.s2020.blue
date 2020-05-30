package ch.bfh.bti7081.s2020.blue.view.layout.footer;

import ch.bfh.bti7081.s2020.blue.presenter.FooterPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FooterViewImpl extends HorizontalLayout implements FooterView {

  private final FooterViewListener listener;

  public FooterViewImpl() {
    listener = new FooterPresenter(this);
    listener.onInit();
    getStyle().set("border-top", "3px solid #000000");
    getStyle().set("width", "100%");
    getStyle().set("text-align", "center");
    getStyle().set("padding-top", "1rem");
    getStyle().set("position", "fixed");
    getStyle().set("bottom", "0px");
  }

  @Override
  public void display() {
    var copyrightLabel = new Label("© by team blue - all rights reserved");
    copyrightLabel.getStyle().set("font-weight", "bolder");
    copyrightLabel.getStyle().set("width", "100%");
    add(copyrightLabel);
  }
}
