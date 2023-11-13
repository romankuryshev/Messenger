package com.rkuryshev.messenger.repository;

import com.rkuryshev.messenger.entity.Chat;
import com.rkuryshev.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<Chat, UUID> {

    List<Chat> findChatsByOwnerUser(User owner);
    Chat findChatByUuid(UUID chatUUID);
}
