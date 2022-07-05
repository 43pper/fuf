package com.secag.fuf.db.entitites;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class UsersChatsSettingsId  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Long userChatId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserChatId() {
        return userChatId;
    }

    public void setUserChatId(Long userChatId) {
        this.userChatId = userChatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersChatsSettingsId)) return false;

        UsersChatsSettingsId that = (UsersChatsSettingsId) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return userChatId != null ? userChatId.equals(that.userChatId) : that.userChatId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userChatId != null ? userChatId.hashCode() : 0);
        return result;
    }
}
