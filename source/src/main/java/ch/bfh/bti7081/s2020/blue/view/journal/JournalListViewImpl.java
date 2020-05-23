package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.domain.dto.JournalListDto;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.github.appreciated.card.StatefulCard;
import com.github.appreciated.card.StatefulCardGroup;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import java.util.Collection;

@Route("journal")
public class JournalListViewImpl extends
    HorizontalLayout implements
    JournalListView, HasUrlParameter<Long> {

  private final BeanInjector beanInjector;
  private final JournalListListener listener;

  public JournalListViewImpl(BeanInjector beanInjector) {
    this.beanInjector = beanInjector;
    listener = new JournalListPresenter(this, beanInjector);
    listener.onInit(null);


  }

  private Component listView(Collection<JournalEntry> entries) {
    StatefulCardGroup<StatefulCard> cardGroup = new StatefulCardGroup<>();
    for (JournalEntry journalEntry : entries) {
      StatefulCard card = new StatefulCard(
          onClick -> listener.journalEntrySelected(journalEntry.getId()),
          new TitleLabel(journalEntry.getTitle()),
          new PrimaryLabel(journalEntry.getContent())
      );
      card.setId(journalEntry.getId().toString());
      card.setWidth("100%");
      card.getStyle().set("margin", "1em");
      cardGroup.add(card);
    }
    return cardGroup;
  }

  public void display(JournalListDto dto) {
    removeAll();
    add(listView(dto.getEntries()));

    VerticalLayout rightComponent = new VerticalLayout();

    // Search
    HorizontalLayout searchBox = new HorizontalLayout();
    TextField searchField = new TextField(
        e -> listener.searchFieldChanged(e.getValue(), e.getOldValue()));
    searchField.setPlaceholder("Search");
    Icon icon = VaadinIcon.SEARCH.create();
    searchField.setPrefixComponent(icon);
    searchField.setValueChangeMode(ValueChangeMode.EAGER);
    searchBox.add(searchField);
    rightComponent.add(searchBox);

    // Reading Pane
    if (dto.getSelectedEntry() != null) {
      JournalDetailViewImpl detailView = new JournalDetailViewImpl(beanInjector);
      detailView.setParameter(null, dto.getSelectedEntry().getId());
      rightComponent.expand(detailView);
    }

    // Add Button
    Button addNew = new Button(new Icon(VaadinIcon.PLUS));
    addNew.addClickListener(event -> listener.addNewClicked());
    rightComponent.setHorizontalComponentAlignment(FlexComponent.Alignment.END,
        addNew);

    add(rightComponent);
  }

  @Override
  public int getScreenSize() {
    return 700;
  }

  @Override
  public void navigate(String route) {
    getUI().ifPresent(ui ->
        ui.navigate(route));
  }

  @Override
  public Long getSelectedEntryId() {
    return null;
  }

  @Override
  public String getSearchFieldValue() {
    return null;
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Long id) {
    listener.onInit(id);
  }

}

