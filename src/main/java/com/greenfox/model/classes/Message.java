package com.greenfox.model.classes;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by zsuzsanna.padar on 2017. 05. 18..
 */
@Entity
@Table(name = "Messages")
public class Message {

  @Id
  long id;

  String text;
  String username;
  Timestamp timestamp;

  public Message() {

  }

  public Message(String username, String text) {
    this.id = (1000000 + (long)(Math.random() * 8999999));
    this.text = text;
    this.username = username;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(long id, String username, String text, Timestamp timestamp) {
    this.id = id;
    this.text = text;
    this.username = username;
    this.timestamp = timestamp;
  }

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public String getUsername() {
    return username;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }
}
