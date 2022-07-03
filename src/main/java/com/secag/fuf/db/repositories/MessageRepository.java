package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Interest;
import com.secag.fuf.db.entitites.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
