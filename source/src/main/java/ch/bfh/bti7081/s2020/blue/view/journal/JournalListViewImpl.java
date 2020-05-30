package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.util.List;

public class JournalListViewImpl extends HorizontalLayout implements JournalListView {

  private final JournalListListener listener;

  public JournalListViewImpl(BeanInjector beanInjector) {
    listener = new JournalListPresenter(this, beanInjector);
    listener.onInit();
  }

  @Override
  public void display(List<JournalEntry> journalEntries) {
    for (JournalEntry journalEntry : journalEntries) {
      Div div = new Div();
      div.getStyle().set("border", "1px solid black");
      div.getStyle().set("padding", "0.5em");
      div.getStyle().set("width", "100%");

      H3 title = new H3(journalEntry.getTitle());
      title.getStyle().set("margin", "0"); // TODO should be in global styles
      div.add(title);

      div.add(new Text(journalEntry.getContent()));

      Button detailButton = new Button("Detail");
      detailButton.addClickListener(event -> listener.onJournalClick(journalEntry.getId()));
      div.add(detailButton);

      add(div);

    }

    Button newJournalEntryButton = new Button(new Icon(VaadinIcon.PLUS));
    newJournalEntryButton.getStyle().set("cursor", "pointer");
    newJournalEntryButton.addClickListener(event -> listener.onJournalEntryAddClick());
    add(newJournalEntryButton);
  }

  @Override
  public void navigateToJournalEntryCreate() {
    getUI().ifPresent(ui -> ui.navigate(JournalCreateViewImpl.class));
  }

  @Override
  public void navigateToDetailView(Long id) {
    getUI().ifPresent(ui -> ui.navigate(JournalDetailViewImpl.class, id));
  }

//  private Component listView(Collection<JournalEntry> entries) {
//    StatefulCardGroup<StatefulCard> cardGroup = new StatefulCardGroup<>();
//    for (JournalEntry journalEntry : entries) {
//      StatefulCard card = new StatefulCard(
//          onClick -> listener.journalEntrySelected(journalEntry.getId()),
//          new TitleLabel(journalEntry.getTitle()),
//          new PrimaryLabel(journalEntry.getContent())
//      );
//      card.setId(journalEntry.getId().toString());
//      card.setWidth("100%");
//      card.getStyle().set("margin", "1em");
//      cardGroup.add(card);
//    }
//    return cardGroup;
//  }
//
//  public void display(JournalListDto dto) {
//    removeAll();
//    add(listView(dto.getEntries()));
//
//    VerticalLayout rightComponent = new VerticalLayout();
//
//    // Search
//    HorizontalLayout searchBox = new HorizontalLayout();
//    TextField searchField = new TextField(
//        e -> listener.searchFieldChanged(e.getValue(), e.getOldValue()));
//    searchField.setPlaceholder("Search");
//    Icon icon = VaadinIcon.SEARCH.create();
//    searchField.setPrefixComponent(icon);
//    searchField.setValueChangeMode(ValueChangeMode.EAGER);
//    searchBox.add(searchField);
//    rightComponent.add(searchBox);
//
//    // Reading Pane
//    if (dto.getSelectedEntry() != null) {
//      JournalDetailViewImpl detailView = new JournalDetailViewImpl(beanInjector);
//      detailView.setParameter(null, dto.getSelectedEntry().getId());
//      rightComponent.expand(detailView);
//    }
//
//    // Add Button
//    Button addNew = new Button(new Icon(VaadinIcon.PLUS));
//    addNew.addClickListener(event -> listener.addNewClicked());
//    rightComponent.setHorizontalComponentAlignment(FlexComponent.Alignment.END,
//        addNew);
//
//    add(rightComponent);
//  }
//
//  @Override
//  public int getScreenSize() {
//    return 700;
//  }
//
//  @Override
//  public void navigate(String route) {
//    getUI().ifPresent(ui ->
//        ui.navigate(route));
//  }
//
//  @Override
//  public Long getSelectedEntryId() {
//    return null;
//  }
//
//  @Override
//  public String getSearchFieldValue() {
//    return null;
//  }
//
//  @Override
//  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Long id) {
//    listener.onInit(id);
//  }

}

