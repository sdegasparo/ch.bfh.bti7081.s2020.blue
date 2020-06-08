package ch.bfh.bti7081.s2020.blue.view.journal;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.layout.SocialAnxietyLayout;
import com.vaadin.flow.router.Route;

@Route("journal")
public class JournalViewImpl extends SocialAnxietyLayout implements JournalView {

  public JournalViewImpl(BeanInjector beanInjector) {
    super(beanInjector);
  }

  @Override
  protected void initializeView(BeanInjector beanInjector) {
    add(new JournalListViewImpl(beanInjector));
  }
}
