package com.rkuryshev.messenger.service;

import com.rkuryshev.messenger.dto.ChatDTO;
import com.rkuryshev.messenger.dto.NewChatRequest;
import com.rkuryshev.messenger.entity.Chat;
import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.exeption.ChatCreationException;
import com.rkuryshev.messenger.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    public final UserService userService;

    private List<ChatDTO> createChatDTOsFromEntity(List<Chat> chats) {
        List<ChatDTO> chatDTOs = new ArrayList<>();
        for(Chat c : chats) {
            chatDTOs.add(c.createDTO());
        }
        return chatDTOs;
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public List<ChatDTO> getAllChatDTOs() {
        return createChatDTOsFromEntity(getAllChats());
    }

    public List<ChatDTO> getUsersChatDTOs(User user) {
        return createChatDTOsFromEntity(chatRepository.findChatsByOwnerUser(user));
    }

    public Chat getChat(UUID chatUUID) {
        return chatRepository.findChatByUuid(chatUUID);
    }
    public ChatDTO getChatDto(UUID chatUUID) {
        return getChat(chatUUID).createDTO();
    }

    public ChatDTO createChat(NewChatRequest newChatRequest) throws ChatCreationException {
        User owner = null;
        User contact = null;
        try {
            owner = userService.findByUsername(newChatRequest.getOwnerUsername()).get();
            contact = userService.findByUsername(newChatRequest.getContactUsername()).get();
        } catch (NoSuchElementException e ){
            throw new ChatCreationException("User doesn't exists");
        }
        Chat currentChat = new Chat(owner, contact);
        chatRepository.save(currentChat);
        chatRepository.save(new Chat(contact, owner));
        return currentChat.createDTO();
    }

    public void updateChat(Chat chat) {
        chatRepository.save(chat);
    }

}
