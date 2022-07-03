package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
