package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final ChatService chatService;
    @GetMapping("/")
    public List<ChatDTO> getChats() {
        return chatService.getAllChatDTOs();
    }

}
