package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("journal")
public class JournalDetailViewImpl extends VerticalLayout implements JournalDetailView, HasUrlParameter<Long> {

  private JournalDetailViewListener listener;
  private Label display = new Label("JournalDetail works!");

  public JournalDetailViewImpl() {
    add(display);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, Long id) {
    listener.findAndDisplay(id);
  }

  @Override
  public void display(JournalEntry journalEntry) {
    Text title = new Text(journalEntry.getTitle());
    Text content = new Text(journalEntry.getContent());
    add(title);
    add(content);
  }

  @Override
  public void addListener(JournalDetailViewListener listener) {
    this.listener = listener;
  }
}
