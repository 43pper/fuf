package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Interest;
import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.entitites.UserInterests;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface UserInterestsRepository extends JpaRepository<UserInterests, Long> {
    Set<UserInterests> findByUserId(Long id);
    Set<UserInterests> findByUserIdAndIsPositiveIsTrue(Long id);
    Set<UserInterests> findByUserIdAndIsPositiveIsFalse(Long id);

    

}
