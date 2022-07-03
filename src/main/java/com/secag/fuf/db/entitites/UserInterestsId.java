package com.secag.fuf.db.entitites;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class UserInterestsId implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Long interestId;

    public UserInterestsId(){}

    public UserInterestsId(Long userId, Long interestId){
        super();
        this.userId = userId;
        this.interestId = interestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInterestId() {
        return interestId;
    }

    public void setInterestId(Long interestId) {
        this.interestId = interestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInterestsId that = (UserInterestsId) o;
        return userId.equals(that.userId) && interestId.equals(that.interestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, interestId);
    }
}
