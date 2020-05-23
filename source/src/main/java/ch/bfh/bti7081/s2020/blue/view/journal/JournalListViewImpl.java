package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalListPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import com.github.appreciated.card.StatefulCard;
import com.github.appreciated.card.StatefulCardGroup;
import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.TitleLabel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import java.util.Collection;
import java.util.Optional;

@Route("journal")
public class JournalListViewImpl extends
    HorizontalLayout implements
    JournalListView, HasUrlParameter<Long> {

  private final BeanInjector beanInjector;
  private final JournalListListener listener;
  private Boolean isMasterAndDetail = null;

  public JournalListViewImpl(BeanInjector beanInjector) {
    this.beanInjector = beanInjector;
    listener = new JournalListPresenter(this, beanInjector);
    listener.onInit(Optional.empty());


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

  public void display(Collection<JournalEntry> entries, Optional<JournalEntry> selected) {
    removeAll();
    add(listView(entries));
    selected.ifPresent(entry -> {
      JournalDetailViewImpl detailView = new JournalDetailViewImpl(beanInjector);
      detailView.setParameter(null, entry.getId());
      add(detailView);
    });
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
  public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Long id) {
    listener.onInit(Optional.ofNullable(id));
  }

}

