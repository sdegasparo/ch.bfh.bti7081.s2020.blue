package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.List;

public class JournalListViewImpl extends VerticalLayout implements JournalListView {

  private final JournalListListener listener;

  public JournalListViewImpl(BeanInjector beanInjector) {
    listener = new JournalListPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  public void display(List<JournalEntry> journalEntries) {
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    H2 title = new H2("Meine Journaleinträge");

    Button newJournalEntryButton = new Button(new Icon(VaadinIcon.PLUS));
    newJournalEntryButton.addClickListener(event -> listener.onJournalEntryAddClick());

    horizontalLayout.add(title, newJournalEntryButton);
    horizontalLayout.getStyle().set("margin", "0");
    horizontalLayout.setAlignItems(Alignment.BASELINE);
    add(horizontalLayout);

    for (JournalEntry journalEntry : journalEntries) {
      Div div = new Div();
      div.getStyle().set("border", "1px solid black");
      div.getStyle().set("padding", "0.5em");
      div.getStyle().set("width", "100%");

      H3 journalEntryTitle = new H3(journalEntry.getTitle());
      div.add(journalEntryTitle);

      div.add(new Text(journalEntry.getContent()));

      Button detailButton = new Button("Detail");
      detailButton.addClickListener(event -> listener.onJournalEntryClick(journalEntry.getId()));
      div.add(detailButton);

      add(div);
    }
  }

  @Override
  public void navigateToJournalEntryCreateView() {
    getUI().ifPresent(ui -> ui.navigate(JournalCreateViewImpl.class));
  }

  @Override
  public void navigateToDetailView(Long id) {
    getUI().ifPresent(ui -> ui.navigate(JournalDetailViewImpl.class, id));
  }
}

