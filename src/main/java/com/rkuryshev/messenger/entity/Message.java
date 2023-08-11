package com.rkuryshev.messenger.entity;

import com.rkuryshev.messenger.dto.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Message {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String text;
    @NonNull
    private LocalDateTime dateTime;

    private Message(String text) {
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
