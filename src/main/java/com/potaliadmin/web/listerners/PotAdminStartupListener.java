package com.potaliadmin.web.listerners;

import com.potaliadmin.domain.address.Country;
import com.potaliadmin.framework.cache.NativeCacheManager;
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

  @Autowired
  BaseDao baseDao;

  public PotAdminStartupListener() {
  }

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    logger.info("=================== STARTING POTALI ADMIN ===================");
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