package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

}
