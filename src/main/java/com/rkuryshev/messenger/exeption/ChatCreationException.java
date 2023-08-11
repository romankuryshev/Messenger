package com.rkuryshev.messenger.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatCreationException extends RuntimeException{
    private String message;
}
