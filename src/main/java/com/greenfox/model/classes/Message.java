package com.greenfox.model.classes;

import com.greenfox.repository.MessageRepository;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by zsuzsanna.padar on 2017. 05. 18..
 */
@Entity
@Table(name = "Messages")
public class Message {

  @Id
  long id;

  String text;
  String userName;
  Timestamp timestamp;

  public Message() {
    this.id = (1000000 + (long)(Math.random() * 9999999));
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(String userName, String text) {
    this.id = (1000000 + (long)(Math.random() * 9999999));
    this.text = text;
    this.userName = userName;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message(long id, String text, String userName, Timestamp timestamp) {
    this.id = id;
    this.text = text;
    this.userName = userName;
    this.timestamp = timestamp;
  }

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public String getUserName() {
    return userName;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }
}
