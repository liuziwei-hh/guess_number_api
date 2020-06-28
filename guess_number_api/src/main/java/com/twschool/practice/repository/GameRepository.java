package com.twschool.practice.repository;

import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameRepository {

    private static final Map<String, GuessNumberGame> gameRepository = new HashMap<>();

    public void set(String userId, GuessNumberGame guessNumberGame) {
        gameRepository.put(userId, guessNumberGame);
    }

    public GuessNumberGame get(String userId) {
        return gameRepository.get(userId);
    }
}
