package ch.bfh.bti7081.s2020.blue.view.layout.footer;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class FooterViewImpl extends HorizontalLayout implements FooterView {

  public FooterViewImpl() {
    getStyle().set("border-top", "3px solid #000000")
        .set("width", "100%")
        .set("text-align", "center")
        .set("padding-top", "1rem");

    var copyrightLabel = new Label("© by team blue - all rights reserved");
    copyrightLabel.getStyle().set("font-weight", "bolder")
        .set("width", "100%");
    add(copyrightLabel);
  }
}
