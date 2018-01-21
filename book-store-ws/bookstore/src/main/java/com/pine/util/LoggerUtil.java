package com.pine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pine.Server;

public class LoggerUtil {
  private static final Logger Log = LoggerFactory.getLogger(Server.class);

  public static void info(String msg) {
    Log.info(msg);
  }

  public static void info(String msg, Throwable th) {
    Log.info(msg, th);
  }

  public static void debug(String msg) {
    Log.debug(msg);
  }

  public static void error(String msg, Throwable th) {
    Log.error(msg, th);
  }

  public static void warn(String msg, Throwable th) {
    Log.warn(msg, th);
  }

}
