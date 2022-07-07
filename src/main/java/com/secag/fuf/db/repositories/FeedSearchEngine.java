package com.secag.fuf.db.repositories;

import com.secag.fuf.db.entitites.User;
import com.secag.fuf.db.entitites.UserInterests;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FeedSearchEngine {
    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static void setUserRepository(UserRepository userRepository) {
        FeedSearchEngine.userRepository = userRepository;
    }

    public static UserInterestsRepository getUserInterestsRepository() {
        return userInterestsRepository;
    }

    public static void setUserInterestsRepository(UserInterestsRepository userInterestsRepository) {
        FeedSearchEngine.userInterestsRepository = userInterestsRepository;
    }

    private static UserRepository userRepository;
    private static UserInterestsRepository userInterestsRepository;
    private static int cardsToGenerate;
    private static Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getCardsToGenerate() {
        return cardsToGenerate;
    }

    public void setCardsToGenerate(int cardsToGenerate) {
        this.cardsToGenerate = cardsToGenerate;
    }

    public static Set<User> process(int profilesCount, Long user) {
        cardsToGenerate = profilesCount;
        userId = user;
        Set<Long> userInterestsId = getUserInterestsId(userId);
        Set<User> resultSet = getSuitableUsers(profilesCount, userInterestsId);
        return resultSet;
    }

    private static Set<Long> getUserInterestsId(Long userId) {
        Set<UserInterests> userInterests = userInterestsRepository.findByUserIdAndIsPositiveIsTrue(userId);
        Set<Long> interests = new HashSet<>();
        userInterests.forEach(record -> interests.add(record.getId().getInterestId()));
        return interests;
    }


    private static Set<User> getSuitableUsers(int profilesCount, Set<Long> userInterestsId) {
        Pageable rowsNum = PageRequest.of(0, profilesCount);
        List<User> users = userRepository.findSuitableUsers(userInterestsId, userId, rowsNum);
//        Set<User> suitableUsers = new HashSet<>();
//        users.forEach(record -> suitableUsers.add(userRepository.findById(record.getId().getUserId()).get()));
        Set<User> suitableUsers = users.stream().distinct().collect(Collectors.toSet());
        if(suitableUsers.size() < profilesCount){
            List<User> nearest = getNearestUsers(suitableUsers, profilesCount - suitableUsers.size());
            suitableUsers.addAll(nearest);
        }
        return suitableUsers;
    }

    private static List<User> getNearestUsers(Set<User> suitableUsers, int countUsers) {
        Long [] alreadyExistUsers = suitableUsers.stream().map(User::getId).toArray(Long[]::new);
        alreadyExistUsers  = Arrays.copyOf(alreadyExistUsers,alreadyExistUsers.length + 1);
        alreadyExistUsers[alreadyExistUsers.length - 1 ] = userId;
        Pageable userLimit = PageRequest.of(0,countUsers);
        return userRepository.getNearbyUsers(alreadyExistUsers,userLimit);
    }




}
