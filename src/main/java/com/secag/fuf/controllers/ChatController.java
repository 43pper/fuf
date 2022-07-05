package com.secag.fuf.controllers;


import com.secag.fuf.db.entitites.Chat;
import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.entitites.UsersChatsSettings;
import com.secag.fuf.db.entitites.UsersChatsSettingsId;
import com.secag.fuf.db.repositories.ChatRepository;
import com.secag.fuf.db.repositories.UserRepository;
import com.secag.fuf.db.repositories.UsersChatsSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsersChatsSettingsRepository usersChatsSettingsRepository;


    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Chat createNewChat(@RequestParam(required=true) Long initiator,
                                            @RequestParam(required=true) Long recipient){

        Optional<User> firstUser = userRepository.findById(initiator);
        Optional<User> secondUser = userRepository.findById(recipient);
        Chat chat = new Chat();
        chat.setUser1(firstUser.get());
        chat.setUser2(secondUser.get());
        Chat newChat = chatRepository.save(chat);
        setUserChatSettings(firstUser, secondUser, newChat);

        return newChat;
    }

    private void setUserChatSettings(Optional<User> firstUser, Optional<User> secondUser, Chat chat) {
        UsersChatsSettings initiatorSettings = new UsersChatsSettings();
        UsersChatsSettings recipientSettings = new UsersChatsSettings();
        initiatorSettings.setUser(firstUser.get());
        initiatorSettings.setAccepted(true);
        initiatorSettings.setNotificationOn(true);
        initiatorSettings.setUserChat(chat);
        recipientSettings.setUser(secondUser.get());
        recipientSettings.setUserChat(chat);
        recipientSettings.setAccepted(false);
        recipientSettings.setNotificationOn(false);
        usersChatsSettingsRepository.save(initiatorSettings);
        usersChatsSettingsRepository.save(recipientSettings);
    }

    @PutMapping(value="/{id}")
    public @ResponseBody UsersChatsSettings updateChatInfo(@PathVariable("id") Long id, @RequestParam(required=true) Long userId,
                                             @RequestParam(required=true) boolean isAccepted,
                                             @RequestParam(required=true) boolean isNotificationOn ) {

        Optional<UsersChatsSettings> chat = usersChatsSettingsRepository.findById(id);
        if (!chat.isPresent()) {
            return null;
        }
        chat.get().setAccepted(isAccepted);
        chat.get().setNotificationOn(isNotificationOn);
        usersChatsSettingsRepository.save(chat.get());

        return chat.get();
    }

    @GetMapping(value="/{id}")
    public @ResponseBody Chat updateChatInfo(@PathVariable("id") Long id) {
        Optional<Chat> chat = chatRepository.findById(id);
        return chat.orElse(null);
    }
}
