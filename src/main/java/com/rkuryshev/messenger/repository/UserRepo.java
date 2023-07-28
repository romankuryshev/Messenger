package com.rkuryshev.messenger.repository;

import com.rkuryshev.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
}
