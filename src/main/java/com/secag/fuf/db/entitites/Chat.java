package com.secag.fuf.db.entitites;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Chat {

    public Chat() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user1;
    @OneToOne
    private User user2;



    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }


}
