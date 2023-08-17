package com.rkuryshev.messenger.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SecureError {
    private Integer id;
    private String message;
}
