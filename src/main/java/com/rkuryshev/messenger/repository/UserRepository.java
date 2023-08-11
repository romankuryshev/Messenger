package com.rkuryshev.messenger.repository;

import com.rkuryshev.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUuid(UUID uuid);
}
