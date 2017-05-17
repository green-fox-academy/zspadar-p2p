package com.greenfox.model;

import java.sql.Timestamp;

/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
public class Log {
  private String path;
  private String method;
  private Timestamp dateAndTime;
  private String logLevel;
  private String requestData;

  public Log() {
  }

  public String getPath() {
    return path;
  }

  public String getMethod() {
    return method;
  }

  public Timestamp getDateAndTime() {
    return dateAndTime;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

}
