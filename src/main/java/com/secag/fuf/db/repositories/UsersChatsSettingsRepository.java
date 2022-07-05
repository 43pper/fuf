package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.entitites.UsersChatsSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersChatsSettingsRepository  extends JpaRepository<UsersChatsSettings, Long> {

}
