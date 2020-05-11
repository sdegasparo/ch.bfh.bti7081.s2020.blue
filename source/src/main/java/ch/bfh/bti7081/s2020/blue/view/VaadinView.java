package ch.bfh.bti7081.s2020.blue.view;

/**
 * Super-Interface for all Vaadin views using the MVP pattern.
 *
 * @param <U> The update object {@link java.lang.reflect.Type}
 */
public interface VaadinView<U> {

  void update(U updateObject);
}
