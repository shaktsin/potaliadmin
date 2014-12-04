package com.potaliadmin.framework.cache;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shakti Singh on 11/15/14.
 */
public class NativeCacheManager {

  private Logger logger = LoggerFactory.getLogger(NativeCacheManager.class);

  private Map<String,String> _mCache = new HashMap<String, String>();
  private static NativeCacheManager _instance;

  static {
    _instance = new NativeCacheManager();
  }


  private NativeCacheManager() {}

  public static NativeCacheManager getInstance() {
    return _instance;
  }

  public void flush() {
    _mCache.clear();
  }

  public synchronized void put(String key, String value) {
    if (key == null || StringUtils.isEmpty(key)) {
      logger.error("Invalid Key insertion in jvm cache");
    } else {
      _mCache.put(key,value);
    }

  }

  public synchronized void delete(String key) {
    if (key == null || StringUtils.isEmpty(key)) {
      logger.error("Invalid Key insertion in jvm cache");
    } else {
      _mCache.remove(key);
    }
  }

}
