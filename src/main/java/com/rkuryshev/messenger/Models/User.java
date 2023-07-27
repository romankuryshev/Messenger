package com.rkuryshev.messenger.Models;

import com.rkuryshev.messenger.DTO.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @NonNull
    @Id
    private UUID uuid;

    @NonNull
    private String name;

    @NonNull
    private String password;

    public User(String name, String password) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.password = password;
    }

    public UserDTO createDTO() {
        return new UserDTO(name);
    }
}
