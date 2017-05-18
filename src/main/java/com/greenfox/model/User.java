package com.greenfox.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
@Entity
@Table(name = "user_table")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  String userName;

  public User(String userName) {
    this.userName = userName;
  }

  public int getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
