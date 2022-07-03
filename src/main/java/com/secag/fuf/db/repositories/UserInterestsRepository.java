package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.UserInterests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestsRepository extends JpaRepository<UserInterests, Long> {
}
