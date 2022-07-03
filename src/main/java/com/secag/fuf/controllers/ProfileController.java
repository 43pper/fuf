package com.secag.fuf.controllers;

import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public String allProfiles() {
        Iterable<User> users = userRepository.findAll();
        System.out.println(users);
        return "";
    }

    @GetMapping("/new")
    public String add(@RequestParam(required=false) String name, @RequestParam(required=false) String lastname,
                      @RequestParam(required=false) String email, @RequestParam(required=false) String password,
                      @RequestParam(required=false) String city, @RequestParam(required=false) String login,
                      @RequestParam(required=false) String photo, @RequestParam(required=false) String phoneNumber,
                      @RequestParam(required=false) String profileDescription,
                      Map<String, Object> model) {
        System.out.println(name);
        User user = new User();
        user.setEmail(email);
        user.setLastName(lastname);
        user.setCity(city);
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        user.setProfileDescription(profileDescription);
        user.setPhoneNumber(phoneNumber);
        user.setPhoto(photo);
        userRepository.save(user);

        User user2 = new User();
        user2.setName("vlad");
        user2.setBlockedUsers(Set.of(user));
        userRepository.save(user2);

        Iterable<User> users = userRepository.findAll();
        model.put("users", users);

        return "";
    }
}
