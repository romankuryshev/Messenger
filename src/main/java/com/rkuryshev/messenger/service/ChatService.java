package com.rkuryshev.messenger.service;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.entity.Chat;
import com.rkuryshev.messenger.repository.ChatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {
    private final ChatRepo chatRepo;

    public List<Chat> getAllChats() {
        return chatRepo.findAll();
    }

    public List<ChatDTO> getAllChatDTOs() {
        List<Chat> chats = chatRepo.findAll();
        List<ChatDTO> chatDTOs = new ArrayList<>();

        for(Chat c : chats) {
            chatDTOs.add(c.createDTO());
        }

        return chatDTOs;
    }

    public void addChat(Chat chat) {
        chatRepo.save(chat);
    }

}
