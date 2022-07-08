package com.secag.fuf.controllers;

import com.secag.fuf.db.entitites.Interest;
import com.secag.fuf.db.entitites.Location;
import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.entitites.UserInterests;
import com.secag.fuf.db.repositories.InterestRepository;
import com.secag.fuf.db.repositories.LocationRepository;
import com.secag.fuf.db.repositories.UserInterestsRepository;
import com.secag.fuf.db.repositories.UserRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Value("${photo.path}")
    private String photoPath;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInterestsRepository userInterestsRepository;

    @Autowired
    private InterestRepository interestRepository;
//    @Autowired
//    private LocationRepository locationRepository;

    @Autowired
    private LocationRepository locationRepository;


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getAllUsers(
            Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        List<User> usersList = new ArrayList<>();
        users.forEach(usersList::add);
        return usersList;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User createNewUser(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname,
                                            @RequestParam(required = true) String email, @RequestParam(required = true) String password,
                                            @RequestParam(required = false) String city, @RequestParam(required = true) String login,
                                            @RequestParam(required = false) String photo, @RequestParam(required = false) String phoneNumber,
                                            @RequestParam(required = false) String profileDescription,
                                            Map<String, Object> model) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setLastName(lastname);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setCity(city);
        newUser.setLogin(login);
        newUser.setPhoto(photo);
        newUser.setProfileDescription(profileDescription);
        newUser.setPhoneNumber(phoneNumber);

        User createdUser = userRepository.save(newUser);
        return createdUser;
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody User updateUserInfo(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String lastname,
                                             @RequestParam(required = false) String email, @RequestParam(required = false) String password,
                                             @RequestParam(required = false) String city, @RequestParam(required = false) String login,
                                             @RequestParam(required = false) String photo, @RequestParam(required = false) String phoneNumber,
                                             @RequestParam(required = false) String profileDescription, @RequestParam(required = false) Set<Location> locations,
                                             Map<String, Object> model) {
        User user = userRepository.findById(id).orElse(new User());
        if (user.getId() == 0) {
            return null;
        }
        User updatedUser = new User();
        updatedUser.setId(user.getId());
        updatedUser.setName(Optional.ofNullable(name).orElse(user.getName()));
        updatedUser.setLastName(Optional.ofNullable(lastname).orElse(user.getLastName()));
        updatedUser.setEmail(Optional.ofNullable(email).orElse(user.getEmail()));
        updatedUser.setPassword(Optional.ofNullable(password).orElse(user.getPassword()));
        updatedUser.setCity(Optional.ofNullable(city).orElse(user.getCity()));
        updatedUser.setLogin(Optional.ofNullable(login).orElse(user.getLogin()));
        updatedUser.setPhoto(Optional.ofNullable(photo).orElse(user.getPhoto()));
        updatedUser.setProfileDescription(Optional.ofNullable(profileDescription).orElse(user.getProfileDescription()));
        updatedUser.setPhoneNumber(Optional.ofNullable(phoneNumber).orElse(user.getPhoneNumber()));
        updatedUser.setFavouriteLocations(locations);
        User createdUser = userRepository.save(updatedUser);
        return createdUser;
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @GetMapping(value = "/{id}/interests")
    public @ResponseBody Set<Interest> getUserInterests(@PathVariable("id") Long id) {
        Set<UserInterests> userInterests = userInterestsRepository.findByUserIdAndIsPositiveIsTrue(id);
        Set<Interest> interests = new HashSet<>();
        for (UserInterests userInterest : userInterests) {
            interests.add(interestRepository.getInterestById(userInterest.getId().getInterestId()));
        }
        return interests;
    }

    @GetMapping(value = "/{id}/bannedinterests")
    public @ResponseBody Set<Interest> getUserBannedInterests(@PathVariable("id") Long id) {
        Set<UserInterests> userInterests = userInterestsRepository.findByUserIdAndIsPositiveIsFalse(id);
        Set<Interest> interests = new HashSet<>();
        for (UserInterests userInterest : userInterests) {
            interests.add(interestRepository.getInterestById(userInterest.getId().getInterestId()));
        }
        return interests;
    }

    @GetMapping(value = "/{id}/locations", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Set<Location> getUserLocations(@PathVariable("id") Long id) {
        Set<Location> returnedLocations = getLocations(id);
        return returnedLocations;
    }

    @GetMapping(value = "/{id}/photo", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getUserPhoto(@PathVariable("id") Long id) throws IOException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return null;
        InputStream in = getClass().getResourceAsStream(photoPath + user.get().getPhoto());
        return IOUtils.toByteArray(in);
    }

    private Set<Location> getLocations(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) return null;
        return locationRepository.findByUsersFavourite(userOptional.get());
    }


}
