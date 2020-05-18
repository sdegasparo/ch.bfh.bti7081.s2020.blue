package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import java.util.List;

public class JournalListViewImpl extends VerticalLayout implements JournalListView {

  private JournalListViewListener listener;

  public JournalListViewImpl(BeanInjector beanInjector) {
    listener = new JournalListPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  public void display(List<JournalEntry> journalEntries) {
    for (JournalEntry journalEntry : journalEntries) {
      add(new RouterLink(journalEntry.getTitle(), JournalDetailViewImpl.class, journalEntry.getId()));
      add(new Text(journalEntry.getContent()));
    }
  }
}

