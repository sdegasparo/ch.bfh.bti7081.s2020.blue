package ch.bfh.bti7081.s2020.blue.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Beans implements InitializingBean, BeanInjector {

  private static Beans instance;

  private final ApplicationContext applicationContext;

  public Beans(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    instance = this;
  }

  public <T> T get(Class<T> beanType) {
    return instance.applicationContext.getBean(beanType);
  }
}
