package com.rkuryshev.messenger.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserError {
    private int id;
    private String message;
}
