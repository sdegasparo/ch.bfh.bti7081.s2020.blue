package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import java.util.List;

public class JournalListViewImpl extends VerticalLayout implements JournalListView {

  private final JournalListViewListener listener;

  public JournalListViewImpl() {
    this.listener = new JournalListPresenter(this);

    Label label = new Label("Journal works!");
    add(label);
  }

  @Override
  public void onInit(List<JournalEntry> journalEntries) {
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
