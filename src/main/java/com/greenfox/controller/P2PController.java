package com.greenfox.controller;

import com.greenfox.model.Log;
import com.greenfox.model.User;
import com.greenfox.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
@Controller
public class P2PController{
  @Autowired
  UserRepository userRepository;
  String error;

  @GetMapping(value = "/")
  public String showIndex(HttpServletRequest request) {
    if(System.getenv("CHAT_APP_LOGLEVEL"). equals("ERROR")) {
      System.err.println("Errrorrrr");
    } else {
      Log log = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""));
      System.out.println(log);
    }
    return "index";
  }

  @GetMapping(value = "/enter")
  public String enterUserName(HttpServletRequest request) {
    if(System.getenv("CHAT_APP_LOGLEVEL"). equals("ERROR")) {
      System.err.println("Errrorrrr");
    } else {
      Log log = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""));
      System.out.println(log);
    }
    return "enter";
  }

  @PostMapping(value = "/enter")
  public String addNewUser (@RequestParam("name") String name, Model model) {
    if (name.isEmpty()) {
      error = "The username field is empty";
      model.addAttribute("error", error);
      return "redirect:/enter";
    } else {
      userRepository.save(new User(name));
      error = "";
      model.addAttribute("error", error);
      return "redirect:/";
    }

  }


}


