package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.service.ChatService;
import com.rkuryshev.messenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {
    private final UserService userService;

    private final ChatService chatService;

    @GetMapping("/")
    public List<ChatDTO> getChats() {
        return chatService.getAllChatDTOs();
    }

    @GetMapping("/secured")
    public String getSecured() {
        return "secured";
    }

    @GetMapping("/public")
    public String getPublic() {
        return "public";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

}
