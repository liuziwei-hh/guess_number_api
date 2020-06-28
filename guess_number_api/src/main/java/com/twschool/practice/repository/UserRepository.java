package com.twschool.practice.repository;

import com.twschool.practice.domain.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<String, User> userRepository = new HashMap<>();

    public void set(String userId, User user) {
        userRepository.put(userId, user);
    }

    public User get(String userId) {
        return userRepository.get(userId);
    }

}
