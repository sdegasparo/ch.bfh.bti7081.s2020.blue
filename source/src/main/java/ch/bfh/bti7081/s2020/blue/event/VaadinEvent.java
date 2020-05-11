package ch.bfh.bti7081.s2020.blue.event;

import ch.bfh.bti7081.s2020.blue.view.VaadinView;
import org.springframework.context.ApplicationEvent;

/**
 * Abstract Event class for Vaadin views using the MVP pattern.
 *
 * @param <U> The update object {@link java.lang.reflect.Type}
 */
public abstract class VaadinEvent<U> extends ApplicationEvent {

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with which the event is
   * associated (never {@code null})
   */
  public VaadinEvent(Object source) {
    super(source);
  }

  public VaadinView<U> getSource() {
    return (VaadinView<U>) super.getSource();
  }
}
