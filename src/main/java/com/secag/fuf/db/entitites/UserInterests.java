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

    public void setUser(User user) {
        this.user = user;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    private boolean isPositive;
}
