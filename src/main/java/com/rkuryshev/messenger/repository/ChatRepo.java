package com.rkuryshev.messenger.repository;

import com.rkuryshev.messenger.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepo extends JpaRepository<Chat, UUID> {

}
