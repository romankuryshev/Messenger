package com.rkuryshev.messenger.Services;

import com.rkuryshev.messenger.DTO.ChatDTO;
import com.rkuryshev.messenger.Models.Chat;
import com.rkuryshev.messenger.Repositorys.ChatRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
