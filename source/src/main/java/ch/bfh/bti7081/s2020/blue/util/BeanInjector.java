package ch.bfh.bti7081.s2020.blue.util;

public interface BeanInjector {

  <T> T get(Class<T> beanType);
}
