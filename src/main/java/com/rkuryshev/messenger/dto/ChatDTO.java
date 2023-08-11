package com.rkuryshev.messenger.dto;

import com.rkuryshev.messenger.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ChatDTO {
    @NonNull
    private UUID uuid;
    @NonNull
    private List<Message> messages;
    @NonNull
    private UserDTO ownerUser;
    @NonNull
    private UserDTO contactUser;
}
