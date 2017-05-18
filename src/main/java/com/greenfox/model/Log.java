package com.greenfox.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
public class Log {
  private String path;
  private String method;
  private String dateAndTime;
  private String logLevel;
  private String requestData;

  public Log() {
  }

  public Log(String path, String method, String requestData) {
    this.path = path;
    this.method = method;
    this.dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
    this.requestData = requestData;
  }

  public String getPath() {
    return path;
  }

  public String getMethod() {
    return method;
  }

  public String getDateAndTime() {
    return dateAndTime;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public void setDateAndTime(String dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  @Override
  public String toString() {
    //2017-05-16 21:47:19.040 INFO Request /message POST text=apple
    return dateAndTime + " " + logLevel + " " + path + " " + method + " " + requestData;
  }
}
