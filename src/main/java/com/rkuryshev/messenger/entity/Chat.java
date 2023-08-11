package com.rkuryshev.messenger.entity;

import com.rkuryshev.messenger.dto.ChatDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Chat {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @OneToMany
    @NonNull
    private List<Message> messages = new ArrayList<>();

    @OneToOne
    @NonNull
    private User ownerUser;

    @NonNull
    @OneToOne
    private User contactUser;

    public Chat(@NonNull User ownerUser, @NonNull User contactUser) {
        this.ownerUser = ownerUser;
        this.contactUser = contactUser;
    }

    public ChatDTO createDTO() {
        return new ChatDTO(messages, ownerUser.createDTO(), contactUser.createDTO());
    }
}
