package ch.bfh.bti7081.s2020.blue.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Beans implements BeanInjector {

  private final ApplicationContext applicationContext;

  public Beans(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  public <T> T get(Class<T> beanType) {
    return applicationContext.getBean(beanType);
  }
}
