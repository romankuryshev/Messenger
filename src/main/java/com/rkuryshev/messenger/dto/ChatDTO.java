package com.rkuryshev.messenger.dto;

import com.rkuryshev.messenger.entity.Message;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ChatDTO {
    private UUID uuid;
    private List<Message> messages;
    private UserDTO ownerUser;
    private UserDTO contactUser;
}
