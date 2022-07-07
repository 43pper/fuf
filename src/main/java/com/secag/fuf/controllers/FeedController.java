package com.secag.fuf.controllers;

import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.repositories.FeedSearchEngine;
import com.secag.fuf.db.repositories.UserInterestsRepository;
import com.secag.fuf.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    UserInterestsRepository userInterestsRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Set<User> getNextProfiles(@PathVariable("id") Long userId, @RequestParam(required = true) Integer profilesNumber) {
        FeedSearchEngine.setUserRepository(userRepository);
        FeedSearchEngine.setUserInterestsRepository(userInterestsRepository);
        return FeedSearchEngine.process(profilesNumber, userId);
    }

}
