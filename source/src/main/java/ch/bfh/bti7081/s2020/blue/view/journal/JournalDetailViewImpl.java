package ch.bfh.bti7081.s2020.blue.view.journal;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@Route("journal")
public class JournalDetailViewImpl extends VerticalLayout implements JournalDetailView, HasUrlParameter<String> {

  private List<JournalDetailViewListener> listeners = new ArrayList<>();

  private Label display = new Label("JournalDetail works!");

  public JournalDetailViewImpl() {
    add(display);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, String id) {
    System.out.println("journalId " + id);
  }

  @Override
  public void addListener(JournalDetailViewListener listener) {
    listeners.add(listener);
  }
}
