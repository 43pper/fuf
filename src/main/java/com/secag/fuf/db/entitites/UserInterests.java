package com.secag.fuf.db.entitites;

import javax.persistence.*;

@Entity
public class UserInterests {
    @EmbeddedId
    private UserInterestsId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("interestId")
    private Interest interest;

    public UserInterestsId getId() {
        return id;
    }

    public void setId(UserInterestsId id) {
        this.id = id;
    }

    private boolean isPositive;
}
