package com.rkuryshev.messenger.Repositorys;

import com.rkuryshev.messenger.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
}
