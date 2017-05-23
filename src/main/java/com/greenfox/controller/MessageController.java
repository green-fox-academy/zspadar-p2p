package com.greenfox.controller;

import com.greenfox.model.Client;
import com.greenfox.model.Message;
import com.greenfox.model.Receive;
import com.greenfox.model.Status;
import com.greenfox.model.StatusError;
import com.greenfox.model.StatusOk;
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

  @PostMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody Receive receive) {
      if (receive.hasMissingFields()) {
        String[] missingFields = receive.getMissingFields();
        Status error = new StatusError(missingFields);
        return error;
      } else {
        // save to db
        // return
        return new StatusOk();
      }
  }

}
