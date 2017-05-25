package com.greenfox.controller;

import com.greenfox.model.classes.Log;
import com.greenfox.model.classes.Message;
import com.greenfox.model.classes.Receive;
import com.greenfox.model.interfaces.Status;
import com.greenfox.model.classes.StatusError;
import com.greenfox.model.classes.StatusOk;
import com.greenfox.repository.MessageRepository;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zsuzsanna.padar on 2017. 05. 22..
 */
@RestController
@CrossOrigin("*")
public class MessageController {
  @Autowired
  private MessageRepository messageRepository;

  RestTemplate restTemplate = new RestTemplate();

  public static final String URI = System.getenv("CHAT_APP_PEER_ADDRESS") + "/api/message/receive";

  @PostMapping(value = "/api/message/receive")
  public Status receiveMessage(HttpServletRequest request, @RequestBody Receive receive) {
    if (receive.hasMissingFields()) {
      Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter("/api/message/receive"), "ERROR");
      logger.log();
      Status error = new StatusError(Arrays.asList(receive.getMissingFields()));
      return error;
    } else {
      Log logger = new Log(request.getMethod(), request.getRequestURI(), request.getParameter("/api/message/receive"), "INFO");
      logger.log();
      // save to db
      messageRepository.save(new Message(receive.getMessage().getId(),
          receive.getMessage().getUsername(),
          receive.getMessage().getText(),
          receive.getMessage().getTimestamp()));
      if (!(receive.getClient().getId().equals(System.getenv("CHAT_APP_UNIQUE_ID")))) {
        restTemplate.postForObject(URI, receive, StatusOk.class);
      }
      // return
      return new StatusOk();
    }
  }

}
