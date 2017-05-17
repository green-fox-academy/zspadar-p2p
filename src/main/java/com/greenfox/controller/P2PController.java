package com.greenfox.controller;


import static java.util.logging.Level.INFO;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
@Controller
public class P2PController {

  @GetMapping(value = "/")
  public String showIndex() {
    if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
      System.out.println("only errors");
    } else {
      System.out.println(new Date() + " " + INFO.getName() +
            " Request / GET");
      }
      return "index";
    }

}


