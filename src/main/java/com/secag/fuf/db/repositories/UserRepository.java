package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.entitites.UserInterests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findByName(String name);
        @Query("select user, count(ui.interest) as interestsCount from User user left join UserInterests ui on user.id = ui.id.userId where (ui.interest.id in (?1) or user.id > 0) and user.id <> ?2 group by user.id order by interestsCount desc")
        List<User> findSuitableUsers(Set<Long> interestIds, Long currentUserId, Pageable pageable);

        @Query("select user from User user  where user.id > 0 AND  user.id not in (?1)")
        List<User> getNearbyUsers(Long[] alreadyExistsUsers,Pageable pageable);

//        void deleteFavouriteLocationsById(Long id);

}
