package com.greenfox.model.classes;

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
    for(int i = 0; i <missingFields.size(); i++ ){
      missingField += String.valueOf(i);
    }
    return missingField;
  }

  public Boolean hasMissingFields() {
    return getMissingFields().length() > 0;
  }

  public Message getMessage() {
    return message;
  }

  public Client getClient() {
    return client;
  }

  public String  isMessageIdMissing() {
   if(String.valueOf(message.getId()).isEmpty()) {
     return "message.id";
   } else {
     return "";
   }
  }

  public String isUserNameMissing() {
    if(message.getUserName().isEmpty()) {
      return "message.username";
    } else {
      return "";
    }
  }

  public String isTextMissing() {
    if(message.getText().isEmpty()) {
      return "message.text";
    } else {
      return "";
    }
  }

  public String isTimeStampMissing() {
    if(String.valueOf(message.getTimestamp()).isEmpty()){
      return "message.timestamp";
    } else {
      return "";
    }
  }

}
