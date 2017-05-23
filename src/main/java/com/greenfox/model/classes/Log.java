package com.greenfox.model.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
public class Log {

  public static final String LOG_LEVEL = System.getenv("CHAT_APP_LOGLEVEL"); // ERROR or INFO

  private String path;
  private String method;
  private String dateAndTime;
  private String logLevel;
  private String requestData;

  public Log() {
  }

  public Log(String path, String method, String requestData, String logLevel) {
    this.path = path;
    this.method = method;
    this.dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    this.logLevel = logLevel;
    this.requestData = requestData;
  }

  public void log() {
    if (logLevel.equals("ERROR")) {
      System.err.println(this);
    } else if (!LOG_LEVEL.equals("ERROR")) {
      System.out.println(this);
    }
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
    //2017-05-16 21:47:19.040 INFO Request /text POST text=apple
    return dateAndTime + " " + logLevel + " " + path + " " + method + " " + requestData;
  }
}
