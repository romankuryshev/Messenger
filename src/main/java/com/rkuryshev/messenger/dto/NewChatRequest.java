package com.rkuryshev.messenger.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NewChatRequest {
    public String ownerUsername;
    public String contactUsername;
}
