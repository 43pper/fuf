package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Location;
import com.secag.fuf.db.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
//    Location findByUserLocations_UserId(Long userId);
    Set<Location> findByUsersFavourite(User user);
}
