package com.secag.fuf.db.entitites;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {
    @Id
    private String id;

    private Integer rating;

    @ManyToMany(mappedBy = "favouriteLocations")
    Set<User> usersFavourite;
}
