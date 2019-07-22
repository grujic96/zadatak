package com.nisuniversity.spring.configuration;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
     return new Class[] { SecurityJavaConfig.class, AppConfig.class, WebConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
     return null;
  }

  @Override
  protected String[] getServletMappings() {
     return new String[] { "/" };
  }
  
  @Override
  protected DispatcherServlet createDispatcherServlet(final WebApplicationContext servletAppContext)
  {
      final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
      dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
      return dispatcherServlet;
  }
}
