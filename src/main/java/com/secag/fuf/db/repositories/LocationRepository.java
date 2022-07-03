package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
