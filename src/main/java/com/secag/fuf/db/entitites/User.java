package com.secag.fuf.db.entitites;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(30) default 'Guest'")
    private String name;
    @Column(columnDefinition = "varchar(30) default 'Unknown'")
    private String lastName;
    @NotNull
    @Column(columnDefinition = "varchar(50) default 'example@domen.com'")
    private String email;
    @Column(columnDefinition = "varchar(13) default '380000000000'", unique = true)
    private String phoneNumber;
    @NotNull
    @Column(columnDefinition = "varchar(20) default 'login'", unique = true)
    private String login;
    @NotNull
    @Column(columnDefinition = "varchar(30) default 'password'")
    private String password;
    @Column(columnDefinition = "varchar(500) default 'photopath'")
    private String photo;
    @Column(columnDefinition = "varchar(40) default 'city'")
    private String city;
    @Column(columnDefinition = "varchar(1000) default 'Nothing yet'")
    private String profileDescription;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<User> blockedUser;

    @OneToMany(mappedBy = "user")
    private Set<UserInterests> userInterests;

    @ManyToMany
    @JoinTable(name="user_locations",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="location_id"))
    private Set<Location> favouriteLocations;

    public Set<UserInterests> getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(Set<UserInterests> userInterests) {
        this.userInterests = userInterests;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    Location currentLocation;

    public Set<User> getBlockedUsers() {
        return blockedUser;
    }

    public void setBlockedUsers(Set<User> blockedUsers) {
        this.blockedUser = blockedUsers;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }
}
