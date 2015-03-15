package com.potaliadmin.web.listerners;

import com.potaliadmin.pact.framework.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Created by Shakti Singh on 11/15/14.
 */
@Component
public class PotAdminStartupListener implements ServletContextListener {

  private Logger logger = LoggerFactory.getLogger(PotAdminStartupListener.class);
  public static String APP_CONTEXT_PATH;
  public static String APP_ROOT_PATH;
  public static String BASE_PATH = "/";

  @Autowired
  BaseDao baseDao;

  public PotAdminStartupListener() {
  }

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    logger.info("=================== STARTING POTALI ADMIN ===================");
    APP_CONTEXT_PATH = servletContextEvent.getServletContext().getContextPath();
    APP_ROOT_PATH = servletContextEvent.getServletContext().getServerInfo();
    logger.info("Set up the root context path as : "+APP_ROOT_PATH);
    /*NativeCacheManager nativeCacheManager = NativeCacheManager.getInstance();
    if (getBaseDao() == null) {
      logger.error("BaseDao is null");
    }
    List<Country> countries = getBaseDao().getAll(Country.class);
    if (countries == null) {
      logger.error("countries is null");
    }

    for (Country country : countries) {
      nativeCacheManager.put(country.getCountryCode().toString(),country.getName());
    }*/
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    logger.info("=================== SHUTTING DOWN POTALI ADMIN ===================");
  }

  public BaseDao getBaseDao() {
    return baseDao;
  }
}
