package com.rkuryshev.messenger.entity;

import com.rkuryshev.messenger.dto.MessageDTO;
import com.rkuryshev.messenger.dto.NewMessageRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Message {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    private String text;
    @NonNull
    private LocalDateTime dateTime;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    public Message(String text, User user) {
        this.text = text;
        this.dateTime = LocalDateTime.now();
        this.user = user;
    }

    public Message(NewMessageRequest newMessageRequest) {
        this.text = newMessageRequest.getText();
    }
    public MessageDTO createDTO() {
        return new MessageDTO( dateTime, text, user.getUuid());
    }

}
