package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
//    Location findByUserLocations_UserId(Long userId);
}
