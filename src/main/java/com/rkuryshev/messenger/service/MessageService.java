package com.rkuryshev.messenger.service;

import com.rkuryshev.messenger.dto.NewMessageRequest;
import com.rkuryshev.messenger.entity.Chat;
import com.rkuryshev.messenger.entity.Message;
import com.rkuryshev.messenger.entity.User;
import com.rkuryshev.messenger.repository.MessagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessagesRepository messagesRepository;
    private final UserService userService;
    private final ChatService chatService;
    public void createNewMessage(NewMessageRequest newMessageRequest) {
        User currentUser = userService.findByUUID(newMessageRequest.getUserId());
        Message message = new Message(newMessageRequest.getText(), currentUser);
        Chat chat = chatService.getChat(newMessageRequest.getChatId());
        chat.getMessages().add(message);
        messagesRepository.save(message);
        chatService.updateChat(chat);
    }

}
