package com.rkuryshev.messenger.repository;

import com.rkuryshev.messenger.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessagesRepository extends JpaRepository<Message, UUID> {

}
