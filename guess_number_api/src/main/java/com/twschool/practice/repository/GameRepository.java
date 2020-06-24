package com.twschool.practice.repository;

import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameRepository {

    private static final Map<String, GuessNumberGame> gameRepository = new HashMap<>();

    public void set(String id, GuessNumberGame guessNumberGame) {
        gameRepository.put(id, guessNumberGame);
    }

    public GuessNumberGame get(String id) {
        return gameRepository.get(id);
    }
}
