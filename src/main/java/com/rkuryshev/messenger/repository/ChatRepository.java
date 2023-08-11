package com.rkuryshev.messenger.repository;

import com.rkuryshev.messenger.entity.Chat;
import com.rkuryshev.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {

    List<Chat> findChatsByOwnerUser(User owner);
    Chat findChatByUuid(UUID chatUUID);
}
