package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.dto.JournalEntryDto;
import ch.bfh.bti7081.s2020.blue.presenter.JournalDetailPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.HomeView;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("journal")
public class JournalDetailViewImpl extends SocialAnxietyLayout implements JournalDetailView,
    HasUrlParameter<Long> {

  private JournalDetailListener listener;
  private Div content;
  private Dialog deleteConfirmationDialog = new Dialog();

  public JournalDetailViewImpl(BeanInjector beanInjector) {
    super(beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    listener = new JournalDetailPresenter(this, beanInjector);
    content = new Div();
    add(content);
  }

  @Override
  public void afterViewInit(JournalEntryDto journalEntryDto) {
    listener.setModel(journalEntryDto);
    var binder = new Binder<>(JournalEntryDto.class);
    binder.setBean(journalEntryDto);
    content.add(createFormLayout(binder));
  }

  @Override
  public void routeToHomeView() {
    getUI().ifPresent(ui -> ui.navigate(HomeView.class));
  }

  @Override
  public void showDeleteConfirmationDialog() {
    deleteConfirmationDialog = new Dialog();

    Label messageLabel = new Label();
    messageLabel.setText("Löschen?");

    Button confirmButton = new Button("Bestätigen", event -> listener.onJournalEntryDeleteConfirm());
    Button cancelButton = new Button("Abbrechen", event -> listener.onJournalEntryDeleteCancel());

    deleteConfirmationDialog.add(messageLabel, confirmButton, cancelButton);
    deleteConfirmationDialog.open();
  }

  @Override
  public void hideDeleteConfirmationDialog() {
    deleteConfirmationDialog.close();
  }

  private FormLayout createFormLayout(Binder<JournalEntryDto> binder) {
    FormLayout formlayout = new FormLayout();

    TextField title = new TextField();
    formlayout.addFormItem(title, "Titel");
    binder.bind(title, JournalEntryDto::getTitle, JournalEntryDto::setTitle);

    TextArea journalEntryContent = new TextArea();
    journalEntryContent.getStyle().set("minHeight", "150px");
    formlayout.addFormItem(journalEntryContent, "Inhalt");
    binder.bind(journalEntryContent, JournalEntryDto::getContent, JournalEntryDto::setContent);

    Button deleteButton = new Button("Löschen");
    deleteButton.addClickListener(event -> listener.onJournalEntryDelete());
    formlayout.add(deleteButton);

    Button updateButton = new Button("Aktualisieren");
    updateButton.addClickListener(event -> listener.onJournalEntryUpdate());
    formlayout.add(updateButton);

    return formlayout;
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, Long id) {
    listener.afterViewInit(id);
  }
}
