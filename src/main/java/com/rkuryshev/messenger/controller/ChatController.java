package com.rkuryshev.messenger.controller;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.dto.NewChatRequest;
import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.exeption.ChatCreationException;
import com.rkuryshev.messenger.service.ChatService;
import com.rkuryshev.messenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ChatController {
    private final UserService userService;
    private final ChatService chatService;

    @GetMapping("/chats/{username}")
    public List<ChatDTO> getUsersChats(@PathVariable String username) {
        User user = null;
        if (userService.findByUsername(username).isPresent()){
            user = userService.findByUsername(username).get();
            return chatService.getUsersChatDTOs(user);
        }
        return null;
    }

    @GetMapping("/{chatUUID}")
    public ChatDTO getChatMessages(@PathVariable UUID chatUUID) {
        return chatService.getChatDto(chatUUID);
    }

    @PostMapping("/createChat")
    public ResponseEntity<?> createNewChat(@RequestBody NewChatRequest newChatRequest) {
        try {
            return ResponseEntity.ok(chatService.createChat(newChatRequest));
        } catch (ChatCreationException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/secured")
    public String getSecured() {
        return "secured";
    }

    @GetMapping(value = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPublic() {
        return "public";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

}
