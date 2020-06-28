package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.domain.User;
import com.twschool.practice.repository.GameRepository;
import com.twschool.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GuessGameService {

    private static final String CORRECT_RESULT = "4A0B";

    private GuessNumberGame guessNumberGame;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    public String guess(String userAnswerString) {
        startGame();
        List<String> userAnswer = Arrays.asList(userAnswerString.split(" "));
        return guessNumberGame.guess(userAnswer);
    }

    public void startGame() {
        if (guessNumberGame == null) {
            guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator());
        }
    }

    public boolean startGame(String userId) {
        if (gameRepository.get(userId) != null && userRepository.get(userId) != null) {
            return false;
        }
        User user = new User(userId);
        userRepository.set(userId, user);
        gameRepository.set(userId, new GuessNumberGame(new RandomAnswerGenerator()));
        return true;
    }

    public boolean isExistUser(String userId) {
        return startGame(userId);
    }

    public String guess(String userId, String userAnswerString) {
        String result = this.gameRepository.get(userId).guess(Arrays.asList(userAnswerString.split(" ")));
        User user = this.userRepository.get(userId);
        if (CORRECT_RESULT.equals(result)) {
            user.win();
        } else {
            user.lose();
        }
        return result;
    }

    public User getUser(String userId) {
        return this.userRepository.get(userId);
    }
}
