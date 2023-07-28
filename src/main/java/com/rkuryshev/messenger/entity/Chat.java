package com.rkuryshev.messenger.entity;

import com.rkuryshev.messenger.dto.ChatDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Chat {

    @Id
    @NonNull
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
        this.uuid = UUID.randomUUID();
        this.ownerUser = ownerUser;
        this.contactUser = contactUser;
    }

    public ChatDTO createDTO() {
        return new ChatDTO(messages, ownerUser.createDTO(), contactUser.createDTO());
    }
}
