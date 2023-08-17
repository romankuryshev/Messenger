package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.dto.NewMessageRequest;
import com.rkuryshev.messenger.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody NewMessageRequest newMessageRequest) {
        messageService.createNewMessage(newMessageRequest);
    }


}
