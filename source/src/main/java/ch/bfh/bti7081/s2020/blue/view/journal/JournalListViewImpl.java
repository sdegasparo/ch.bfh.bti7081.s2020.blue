package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.event.LoadJournalListEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import java.util.List;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class JournalListViewImpl extends VerticalLayout implements JournalListView {

  private ApplicationEventPublisher applicationEventPublisher;

  public JournalListViewImpl(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;

    initialLoad();
  }

  private void initialLoad() {
    applicationEventPublisher.publishEvent(new LoadJournalListEvent(this));
  }

  @Override
  public void update(List<JournalEntry> journalEntries) {
    for (JournalEntry journalEntry : journalEntries) {
      Text title = new Text(journalEntry.getTitle());
      Text text = new Text(journalEntry.getContent());
      Div div = new Div();
      div.add(title);
      div.add(text);
      add(div);
      RouterLink routerLink = new RouterLink("journal", JournalDetailViewImpl.class,
          journalEntry.getId());
      add(routerLink);
    }
  }
}
