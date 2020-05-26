package ch.bfh.bti7081.s2020.blue.view.layout;

import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.layout.footer.FooterViewImpl;
import ch.bfh.bti7081.s2020.blue.view.layout.header.HeaderViewImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public abstract class SocialAnxietyLayout extends VerticalLayout {

  public SocialAnxietyLayout(BeanInjector beanInjector) {
    add(new HeaderViewImpl());

    initializeView(beanInjector);

    add(new FooterViewImpl());

    this.getStyle().set("height", "calc(100% - 75px)");
    this.getStyle().set("overflow-y", "auto");

  }

  protected abstract void initializeView(BeanInjector beanInjector);
}
