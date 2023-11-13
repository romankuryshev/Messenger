package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.dto.NewChatRequest;
import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.exeption.ChatCreationException;
import com.rkuryshev.messenger.service.ChatService;
import com.rkuryshev.messenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ChatController {
    private final UserService userService;

    private final ChatService chatService;

    @Autowired
    public ChatController(UserService userService, ChatService chatService) {
        this.userService = userService;
        this.chatService = chatService;
    }

    @GetMapping("/chats/{username}")
    public List<ChatDTO> getUsersChats(@PathVariable String username) {
        User user = null;
        if (userService.findByUsername(username).isPresent()){
            user = userService.findByUsername(username).get();
            return chatService.getUsersChatDTOs(user);
        }
        return null;
    }

    @GetMapping("/getChat/{chatUUID}")
    public ChatDTO getChatMessages(@PathVariable UUID chatUUID) {
        return chatService.getChatDto(chatUUID);
    }

    @PostMapping("/createChat")
    public ChatDTO createNewChat(@RequestBody NewChatRequest newChatRequest) throws ChatCreationException {
        return chatService.createChat(newChatRequest);
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
