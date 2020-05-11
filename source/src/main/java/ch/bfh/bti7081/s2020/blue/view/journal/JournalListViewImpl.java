package ch.bfh.bti7081.s2020.blue.view.journal;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import java.util.ArrayList;
import java.util.List;

public class JournalListViewImpl extends VerticalLayout implements JournalListView {

  private List<JournalListViewListener> listeners = new ArrayList<>();

  public JournalListViewImpl() {
    Label label = new Label("Journal works!");
    add(label);

    RouterLink routerLink = new RouterLink("journal", JournalDetailViewImpl.class, "EnterJournalIdHere");
    add(routerLink);
  }

  @Override
  public void addListener(JournalListViewListener listener) {
    listeners.add(listener);
  }
}
