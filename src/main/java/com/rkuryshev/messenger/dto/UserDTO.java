package com.rkuryshev.messenger.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class UserDTO {
    @NonNull
    private String username;
}
