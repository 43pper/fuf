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


    @OneToMany(mappedBy = "interest")
    Set<UserInterests> userInterests;

}
