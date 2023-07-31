package com.rkuryshev.messenger.service;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.entity.Chat;
import com.rkuryshev.messenger.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public List<ChatDTO> getAllChatDTOs() {
        List<Chat> chats = chatRepository.findAll();
        List<ChatDTO> chatDTOs = new ArrayList<>();

        for(Chat c : chats) {
            chatDTOs.add(c.createDTO());
        }

        return chatDTOs;
    }

    public void addChat(Chat chat) {
        chatRepository.save(chat);
    }

}
