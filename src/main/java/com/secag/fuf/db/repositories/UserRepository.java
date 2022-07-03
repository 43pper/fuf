package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByName(String name);
}
