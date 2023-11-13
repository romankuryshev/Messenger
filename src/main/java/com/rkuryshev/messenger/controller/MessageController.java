package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.dto.NewMessageRequest;
import com.rkuryshev.messenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody NewMessageRequest newMessageRequest) {
        messageService.createNewMessage(newMessageRequest);
    }
}
