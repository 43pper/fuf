package com.secag.fuf.db.entitites;

import javax.persistence.*;

@Entity
public class UsersChatsSettings {

    @EmbeddedId
    private UsersChatsSettingsId id;

    @ManyToOne
    @MapsId("userId")
    private User User;

    @ManyToOne
    @MapsId("userChatId")
    private Chat userChat;

    @Column(columnDefinition = "boolean default true")
    private boolean isNotificationOn;

    @Column(columnDefinition = "boolean default false" )
    private boolean isAccepted;

    public boolean isNotificationOn() {
        return isNotificationOn;
    }

    public void setNotificationOn(boolean notificationOn) {
        isNotificationOn = notificationOn;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public com.secag.fuf.db.entitites.User getUser() {
        return User;
    }

    public void setUser(com.secag.fuf.db.entitites.User user) {
        User = user;
    }

    public Chat getUserChat() {
        return userChat;
    }

    public void setUserChat(Chat userChat) {
        this.userChat = userChat;
    }
}