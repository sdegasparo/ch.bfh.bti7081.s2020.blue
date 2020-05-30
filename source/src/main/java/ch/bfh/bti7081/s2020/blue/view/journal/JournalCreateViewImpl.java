package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryDto;
import ch.bfh.bti7081.s2020.blue.presenter.JournalCreatePresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("journal/create")
public class JournalCreateViewImpl extends SocialAnxietyLayout implements JournalCreateView {

  private JournalCreatePresenter listener;

  public JournalCreateViewImpl(BeanInjector beanInjector) {
    super(beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    var binder = new Binder<>(JournalEntryDto.class);
    JournalEntryDto journalEntry = new JournalEntryDto();
    binder.setBean(journalEntry);

    listener = new JournalCreatePresenter(journalEntry, this, beanInjector);

    add(createFormLayout(binder));
  }

  private FormLayout createFormLayout(Binder<JournalEntryDto> binder) {
    FormLayout formlayout = new FormLayout();

    TextField title = new TextField();
    formlayout.addFormItem(title, "Titel");
    binder.bind(title, JournalEntryDto::getTitle, JournalEntryDto::setTitle);

    TextField content = new TextField();
    formlayout.addFormItem(content, "Inhalt");
    binder.bind(content, JournalEntryDto::getContent, JournalEntryDto::setContent);

    Button createButton = new Button("Erstellen");
    createButton.getStyle().set("cursor", "pointer");
    createButton.addClickListener(event -> listener.onJournalEntryCreate());
    formlayout.add(createButton);

    return formlayout;
  }
}
