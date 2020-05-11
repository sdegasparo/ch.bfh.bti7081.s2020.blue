package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalDetailPresenter;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("journal")
public class JournalDetailViewImpl extends VerticalLayout implements JournalDetailView,
    HasUrlParameter<Long> {

  private final JournalDetailViewListener listener;

  public JournalDetailViewImpl() {
    this.listener = new JournalDetailPresenter(this);
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
}
