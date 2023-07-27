package com.rkuryshev.messenger.Repositorys;

import com.rkuryshev.messenger.Models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepo extends JpaRepository<Chat, UUID> {

}
