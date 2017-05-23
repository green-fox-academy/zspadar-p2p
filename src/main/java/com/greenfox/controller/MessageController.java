package com.greenfox.controller;

import com.greenfox.model.classes.Message;
import com.greenfox.model.classes.Receive;
import com.greenfox.model.interfaces.Status;
import com.greenfox.model.classes.StatusError;
import com.greenfox.model.classes.StatusOk;
import com.greenfox.repository.MessageRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsuzsanna.padar on 2017. 05. 22..
 */
@RestController
@CrossOrigin("*")
public class MessageController {
  @Autowired
  private MessageRepository messageRepository;

  @PostMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody Receive receive) {
      if (receive.hasMissingFields()) {
        Status error = new StatusError(Arrays.asList(receive.getMissingFields()));
        return error;
      } else {
        // save to db
        messageRepository.save(new Message(receive.getMessage().getId(),
                                           receive.getMessage().getUsername(),
                                           receive.getMessage().getText(),
                                           receive.getMessage().getTimestamp()));
        // return
        return new StatusOk();
      }
  }

}
