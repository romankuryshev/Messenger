package com.rkuryshev.messenger.Models;

import com.rkuryshev.messenger.DTO.MessageDTO;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class Message {

    @NonNull
    private UUID id;
    @NonNull
    private String text;
    @NonNull
    private LocalDateTime dateTime;

    private Message(String text) {
        id = UUID.randomUUID();
        this.text = text;
        this.dateTime = LocalDateTime.now();
    }

    public static Message createMessage(String text) {
        return new Message(text);
    }

    public MessageDTO createDTO() {
        return new MessageDTO(text, dateTime);
    }

}
