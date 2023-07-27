package com.rkuryshev.messenger.Controllers;

import com.rkuryshev.messenger.DTO.ChatDTO;
import com.rkuryshev.messenger.Services.ChatService;
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
