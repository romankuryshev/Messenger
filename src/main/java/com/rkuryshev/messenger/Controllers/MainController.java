package com.rkuryshev.messenger.Controllers;

import com.rkuryshev.messenger.DTO.MessageDTO;
import com.rkuryshev.messenger.Models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public MessageDTO sayHello() {
        return Message.createMessage( "Hello!").createDTO();
    }

}
