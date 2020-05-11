package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.event.LoadJournalDetailEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Route("journal")
public class JournalDetailViewImpl extends VerticalLayout implements JournalDetailView,
    HasUrlParameter<Long> {

  private ApplicationEventPublisher applicationEventPublisher;

  public JournalDetailViewImpl(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, Long id) {
    applicationEventPublisher.publishEvent(new LoadJournalDetailEvent(this, id));
  }

  @Override
  public void update(JournalEntry journalEntry) {
    Text title = new Text(journalEntry.getTitle());
    Text content = new Text(journalEntry.getContent());
    add(title);
    add(content);
  }
}
