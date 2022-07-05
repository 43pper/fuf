package com.secag.fuf.controllers;

import com.secag.fuf.db.entitites.Interest;
import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.repositories.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/interests")
public class InterestController {

    @Autowired
    private InterestRepository interestRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Interest> getAllInterests(
            Map<String, Object> model) {
        Iterable<Interest> interests = interestRepository.findAll();
//        model.put("interests", interests);
        List<Interest> interestsList = new ArrayList<>();
        interests.forEach(interestsList::add);
        return interestsList;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Interest getAllInterests(@RequestParam(required = true) String emojiUnicode,
                                                  @RequestParam(required = true) String interestTitle,
            Map<String, Object> model) {
//        model.put("interests", interests);
        Interest newInterest = new Interest();
        newInterest.setEmoji(emojiUnicode);
        newInterest.setTitle(interestTitle);
        return interestRepository.save(newInterest);
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Interest updateInterest(@RequestParam(required = true) Long interestId,
                                                 @RequestParam(required = false) String emojiUnicode,
                                                 @RequestParam(required = false) String interestTitle,
            Map<String, Object> model) {
//        model.put("interests", interests);
        Optional<Interest> interestOptional = interestRepository.findById(interestId);
        if (interestOptional.isEmpty()) {
            return null;
        }
        Interest interest = interestOptional.get();
        interest.setEmoji(Optional.ofNullable(emojiUnicode).orElse(interest.getEmoji()));
        interest.setTitle(Optional.ofNullable(interestTitle).orElse(interest.getTitle()));
        return interestRepository.save(interest);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Interest getInterest(@PathVariable("id") Long id,
            Map<String, Object> model) {
//        model.put("interests", interests);
        Optional<Interest> interestOptional = interestRepository.findById(id);
        if (interestOptional.isEmpty()) {
            return null;
        }
        return interestOptional.get();
    }



}
