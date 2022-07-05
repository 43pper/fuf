package com.secag.fuf.db.entitites;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String emoji;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    @OneToMany(mappedBy = "interest")
    Set<UserInterests> userInterests;

}
