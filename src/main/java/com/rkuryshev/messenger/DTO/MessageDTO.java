package com.rkuryshev.messenger.DTO;

import com.rkuryshev.messenger.Models.Message;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MessageDTO {
    @NonNull
    private String text;
    @NonNull
    private LocalDateTime dateTime;

    public MessageDTO(@NonNull String text, @NonNull LocalDateTime dateTime) {
        this.text = text;
        this.dateTime = dateTime;
    }

}
