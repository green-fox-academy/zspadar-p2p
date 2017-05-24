package com.greenfox.controller;


import com.greenfox.model.classes.Client;
import com.greenfox.model.classes.Log;
import com.greenfox.model.classes.Message;
import com.greenfox.model.classes.Receive;
import com.greenfox.model.classes.StatusOk;
import com.greenfox.model.classes.User;
import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


/**
 * Created by zsuzsanna.padar on 2017. 05. 17..
 */
@Controller
public class P2PController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private MessageRepository messageRepository;

  RestTemplate restTemplate = new RestTemplate();

  private String error;
  public static final String URI = System.getenv("CHAT_APP_PEER_ADDRESS") + "/api/message/receive";

  @GetMapping(value = "/")
  public String showIndex(HttpServletRequest request, Model model) {
    Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "INFO");
    logger.log();
    if(userRepository.count() == 0) {
      return "redirect:/enter";
    }
    User user = userRepository.findOne((long) 1);
    model.addAttribute("currentUser", user.getUsername());
    List<Message> messageList;
    messageList = (List<Message>) messageRepository.findAll();
    model.addAttribute("text", messageList);
    return "index";
  }

  @GetMapping(value = "/enter")
  public String enterUserName(HttpServletRequest request, Model model) {
    Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "INFO");
    logger.log();
    model.addAttribute("error", error);
    return "enter";
  }

  @PostMapping(value = "/enter/add")
  public String addNewUser(HttpServletRequest request, @RequestParam("name") String name, Model model) {
    if (name.equals("")) {
      error = "The username field is empty";
      model.addAttribute("error", error);
      Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "ERROR");
      logger.log();
      return "redirect:/enter";
    } else {
      userRepository.save(new User(name));
      error = "";
      model.addAttribute("error", error);
      Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "INFO");
      logger.log();
      return "redirect:/";
    }
  }

  @GetMapping(value = "/update")
  public String upDate(HttpServletRequest request, @RequestParam("username") String userName) {
    if (userName.equals("")) {
      error = "The username field is empty";
      Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "ERROR");
      logger.log();
      return "redirect:/";
    } else {
      User user = userRepository.findOne((long) 1);
      upDatedUser(user, userName);
      Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "INFO");
      logger.log();
      return "redirect:/";
    }

  }

  private void upDatedUser(User user, String userName) {
    user.setUsername(userName);
    userRepository.save(user);
  }

  @PostMapping(value = "/send")
  public String sendMessage(HttpServletRequest request, @RequestParam("text") String message, Model model) {
    Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter(""), "INFO");
    logger.log();
    User user = userRepository.findOne((long) 1);
    Message message1 = new Message(user.getUsername(), message);
    messageRepository.save(message1);
    Client client = new Client();
    client.setId(System.getenv("CHAT_APP_UNIQUE_ID"));
//    Message message1 = new Message(userRepository.findOne((long) 1).getUsername(), message);
    Receive receive = new Receive(client, message1);
//    if(!(receive.getClient().getId().equals(System.getenv("CHAT_APP_UNIQUE_ID")))) {
      restTemplate.postForObject(URI, receive, StatusOk.class);
//    }
    return "redirect:/";

  }

}


