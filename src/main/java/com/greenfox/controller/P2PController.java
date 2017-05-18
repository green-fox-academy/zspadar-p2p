package com.greenfox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
@Controller
public class P2PController {

  @GetMapping(value = "/")
  public String showIndex() {
    if(System.getenv("CHAT_APP_LOGLEVEL"). equals("ERROR")) {
      System.err.println("Errrorrrr");
    } else {
      System.out.println("INFO");
    }
    return "index";
  }

  @GetMapping(value = "/enter")
  public String enterUserName() {
    return "enter";
  }


}


