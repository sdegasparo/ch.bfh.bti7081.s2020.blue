package ch.bfh.bti7081.s2020.blue.presenter;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import ch.bfh.bti7081.s2020.blue.service.JournalService;
import ch.bfh.bti7081.s2020.blue.view.journal.JournalListView;
import com.vaadin.flow.router.Router;
import com.vaadin.flow.server.RouteRegistry;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class JournalListPresenter implements JournalListView.JournalListViewListener {

  private JournalListView view;
  private JournalService journalService;

  public JournalListPresenter(JournalService journalService) {
    this.journalService = journalService;
  }

  public void setView(JournalListView view) {
    this.view = view;
    this.view.addListener(this);
    onInit();
  }

  @Override
  public void onInit() {
    view.onInit(journalService.findAll());
  }


}
