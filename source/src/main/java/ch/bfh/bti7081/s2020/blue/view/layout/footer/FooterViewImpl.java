package ch.bfh.bti7081.s2020.blue.view.layout.footer;

import ch.bfh.bti7081.s2020.blue.presenter.FooterPresenter;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FooterViewImpl extends HorizontalLayout implements FooterView {

  private final FooterViewListener listener;

  public FooterViewImpl() {
    listener = new FooterPresenter(this);
    listener.onInit();
    this.getStyle().set("position", "absolute");
    this.getStyle().set("bottom", "0px");
    this.getStyle().set("left", "16px");
    this.getStyle().set("right", "16px");
    this.getStyle().set("text-align", "center");
    this.getStyle().set("border-top", "3px solid rgb(0, 0, 0)");

    this.setHeight("78px");
    this.setWidth("calc(100% - 32px)");
  }

  @Override
  public void display() {
    var copyrightLabel = new Label("© by team blue - all rights reserved");
    copyrightLabel.getStyle().set("font-weight", "bolder");
    copyrightLabel.getStyle().set("padding-top", "16px");
    copyrightLabel.setWidth("100%");

    add(copyrightLabel);
  }
}
