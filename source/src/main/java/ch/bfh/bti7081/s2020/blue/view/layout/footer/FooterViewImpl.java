package ch.bfh.bti7081.s2020.blue.view.layout.footer;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.util.ArrayList;
import java.util.List;

public class FooterViewImpl extends HorizontalLayout implements FooterView {

  private final List<FooterViewListener> listeners = new ArrayList<>();

  public FooterViewImpl() {
    Label label = new Label("Footer works!");
    add(label);
  }

  @Override
  public void addListener(FooterViewListener listener) {
    listeners.add(listener);
  }
}
