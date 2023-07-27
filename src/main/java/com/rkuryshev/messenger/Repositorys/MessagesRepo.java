package com.rkuryshev.messenger.Repositorys;

import com.rkuryshev.messenger.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessagesRepo extends JpaRepository<Message, UUID> {

}
