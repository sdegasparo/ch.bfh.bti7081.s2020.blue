package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.presenter.JournalDetailPresenter;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("journal")
public class JournalDetailViewImpl extends SocialAnxietyLayout implements JournalDetailView, HasUrlParameter<Long> {

  private final JournalDetailListener listener;
  private Div content;

  public JournalDetailViewImpl(BeanInjector beanInjector) {
    super(beanInjector);
    listener = new JournalDetailPresenter(this, beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    content = new Div();
    add(content);
  }

  @Override
  public void setParameter(BeforeEvent beforeEvent, Long id) {
    listener.onInit(id);
  }

  @Override
  public void display(JournalEntry journalEntry) {
    content.add(new Text(journalEntry.getTitle()));
    content.add(new Text(journalEntry.getContent()));
  }
}
