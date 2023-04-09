package com.kyn.socialintegration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kyn.socialintegration.dto.MessageDto;
import com.kyn.socialintegration.service.MessageService;



@RestController
@RequestMapping("/api/messages")
public class WebhookController {

  @Autowired
  private MessageService messageSender;

  @PostMapping(path = "/{userName}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void sendMessage(@PathVariable("userName") String userName, @RequestBody MessageDto message)
      throws JsonProcessingException {

    messageSender.sendMessage(userName, message);
  }
}