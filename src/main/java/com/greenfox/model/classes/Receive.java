package com.greenfox.model.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsuzsanna.padar on 2017. 05. 22..
 */
public class Receive {
  private Message message;
  private Client client;

  public Receive() {
  }

  public Receive(Client client, Message message) {
    this.message = message;
    this.client = client;
  }

  public String getMissingFields() {
    String missingField = "";
    List<String> missingFields = new ArrayList<>();
    // TODO check fields
    missingFields.add(isMessageIdMissing());
    missingFields.add(isUserNameMissing());
    missingFields.add(isTextMissing());
    missingFields.add(isTimeStampMissing());
    missingFields.add(isClientIdMissing());
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

  private String  isMessageIdMissing() {
   try {
    if(String.valueOf(message.getId()).isEmpty()) {
      return "message.id";
      }
   } catch (NullPointerException ex) {
      return "message.id";
     }
     return "";
  }

  private String isUserNameMissing() {
    try {
      if (message.getUsername().isEmpty()) {
        return "message.username";
      }
    } catch (NullPointerException ex) {
      return "message.username";
    }
    return "";
  }

  private String isTextMissing() {
    try {
      if (message.getText().isEmpty()) {
        return "message.text";
      }
    } catch (NullPointerException ex) {
      return "message.text";
    }
      return "";
  }

  private String isTimeStampMissing() {
    try {
      if (message.getTimestamp() == null) {
        return "message.timestamp";
      }
    } catch (NullPointerException ex) {
      return "message.timestamp";
    }
    return "";
  }

  private String isClientIdMissing() {
    try {
      if(client.getId() == null) {
        return "client.id";
      }
    }catch (NullPointerException ex) {
      return "client.id";
    }
    return "";
  }

}
