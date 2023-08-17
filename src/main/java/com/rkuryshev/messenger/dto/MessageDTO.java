package com.rkuryshev.messenger.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class MessageDTO {
    @NonNull
    private LocalDateTime dateTime;
    @NonNull
    private String text;
    @NonNull
    private UUID userId;
}
