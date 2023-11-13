package com.rkuryshev.messenger.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class MessageDTO {
    private LocalDateTime dateTime;
    private String text;
    private UUID userId;
}
