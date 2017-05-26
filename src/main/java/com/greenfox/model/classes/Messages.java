package com.greenfox.model.classes;

import java.util.List;

/**
 * Created by zsuzsanna.padar on 2017. 05. 26..
 */
public class Messages {
  private List<Message> messages;
  private Client client;

  public Messages(List<Message> messages, Client client) {
    this.messages = messages;
    this.client = client;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public Client getClient() {
    return client;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
