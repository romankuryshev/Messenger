package com.rkuryshev.messenger.DTO;

import com.rkuryshev.messenger.Models.Message;
import com.rkuryshev.messenger.Models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ChatDTO {
    @NonNull
    private List<Message> messages;

    @NonNull
    private UserDTO ownerUser;

    @NonNull
    private UserDTO contactUser;
}
