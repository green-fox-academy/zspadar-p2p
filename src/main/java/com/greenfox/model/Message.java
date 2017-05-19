package com.greenfox.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

  String message;
  String userName;
  Timestamp timestamp;


  public Message() {
    this.id = (1000000 + (long)(Math.random() * 9999999));
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(String userName, String message) {
    this.id = (1000000 + (long)(Math.random() * 9999999));
    this.message = message;
    this.userName = userName;
    this.timestamp = new Timestamp(System.currentTimeMillis());

  }

  public long getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }

  public String getUserName() {
    return userName;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }
}
