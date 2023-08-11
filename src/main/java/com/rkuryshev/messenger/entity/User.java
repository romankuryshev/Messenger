package com.rkuryshev.messenger.entity;

import com.rkuryshev.messenger.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
public class User {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    @ManyToMany
    private Set<Role> roleSet;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO createDTO() {
        return new UserDTO(username);
    }
}
