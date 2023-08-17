package com.rkuryshev.messenger.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
public class NewMessageRequest {
    @NonNull
    private String text;
    @NonNull
    private UUID userId;
    @NonNull
    private UUID chatId;
    public NewMessageRequest(@NonNull String text, @NonNull UUID userId, @NonNull UUID chatId) {
        this.text = text;
        this.userId = userId;
        this.chatId = chatId;
    }
}
