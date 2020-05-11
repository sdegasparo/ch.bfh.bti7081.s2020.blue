package ch.bfh.bti7081.s2020.blue.view.header;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.util.ArrayList;
import java.util.List;

public class HeaderViewImpl extends HorizontalLayout implements HeaderView {

  private List<HeaderViewListener> listeners = new ArrayList<>();

  public HeaderViewImpl() {
    Label label = new Label("Header works!");
    add(label);
  }

  @Override
  public void addListener(HeaderViewListener listener) {
    listeners.add(listener);
  }
}
