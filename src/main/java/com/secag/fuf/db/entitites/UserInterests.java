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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Interest getInterest() {
        return interest;
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

    public void setId(UserInterestsId id) {
        this.id = id;
    }

    private boolean isPositive;
}
