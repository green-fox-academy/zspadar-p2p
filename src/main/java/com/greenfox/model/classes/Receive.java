package com.greenfox.model.classes;

import com.sun.jdi.LongValue;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsuzsanna.padar on 2017. 05. 22..
 */
public class Receive {
  private Message message;
  private Client client;

  public String getMissingFields() {
    String missingField = "";
    List<String> missingFields = new ArrayList<>();
    // TODO check fields
    missingFields.add(isMessageIdMissing());
    missingFields.add(isUserNameMissing());
    missingFields.add(isTextMissing());
    missingFields.add(isTimeStampMissing());
    for(String temp: missingFields){
      missingField +=temp;
    }
    return missingField;
  }

  public Boolean hasMissingFields() {
    System.out.println(getMissingFields().length());
    return getMissingFields().trim().length() != 0;
  }

  public Message getMessage() {
    return message;
  }

  public Client getClient() {
    return client;
  }

  public String  isMessageIdMissing() {
   try {
    if(String.valueOf(message.getId()).isEmpty()) {
      return "message.id";
    }
   } catch (NullPointerException ex) {
      return "message.id";
     }
     return "";
  }

  public String isUserNameMissing() {
    try {
      if (message.getUsername().isEmpty()) {
        return "message.username";
      }
    } catch (NullPointerException ex) {
      return "message.username";
    }
    return "";
  }

  public String isTextMissing() {
    try {
      if (message.getText().isEmpty()) {
        return "message.text";
      }
    }catch (NullPointerException ex){
      return "message.text";
    }
      return "";

  }

  public String isTimeStampMissing() {
    try {
      if (message.getTimestamp() == null) {
        return "message.timestamp";
      }
    } catch (NullPointerException ex) {
      return "message.timestamp";
    }
    return "";
  }

}
