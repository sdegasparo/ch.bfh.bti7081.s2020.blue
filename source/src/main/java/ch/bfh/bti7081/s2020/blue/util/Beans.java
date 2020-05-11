package ch.bfh.bti7081.s2020.blue.util;

import com.vaadin.flow.server.VaadinServlet;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Beans {

  public static <T> T get(Class<T> serviceType) {
    return WebApplicationContextUtils
        .getWebApplicationContext(VaadinServlet.getCurrent().getServletContext())
        .getBean(serviceType);
  }
}