package com.secag.fuf.db.entitites;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user1;
    @OneToOne
    private User user2;
    @Column(columnDefinition = "boolean default false")
    private boolean isAccepted;
    @Column(columnDefinition = "boolean default true")
    private boolean isNotificationOn;



}
