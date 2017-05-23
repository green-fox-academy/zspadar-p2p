package com.greenfox.model;

/**
 * Created by zsuzsanna.padar on 2017. 05. 22..
 */
public class Receive {
  private Message message;
  private Client client;

  public String[] getMissingFields() {
    String[] missingFields = {"message.username", "client.id"};
    // TODO check fields
    return missingFields;
  }

  public Boolean hasMissingFields() {
    return getMissingFields().length > 0;
  }

}
