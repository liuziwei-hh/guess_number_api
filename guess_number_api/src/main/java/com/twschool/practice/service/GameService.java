package com.twschool.practice.service;

import com.twschool.practice.domain.CalculateScore;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    private GuessNumberGame guessNumberGame;
    Map<String, CalculateScore> userInfoMap = new HashMap<>();
    private CalculateScore calculateScore;
    int userScore;
    int sucessTimes;

    public Map<String, Object> guess(String userName, String userAnswerString) {
        Map<String, Object> map = new HashMap();
        if (userInfoMap.get(userName) == null) {
            calculateScore = new CalculateScore(0, 0);
            guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator(), calculateScore);
            userInfoMap.put(userName, calculateScore);
        }
        List<String> userAnswer = Arrays.asList(userAnswerString.split(" "));
        String result = guessNumberGame.guess(userAnswer);
        if (guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            userScore = calculateScore.getUserScore() + 3;
            sucessTimes = calculateScore.getSuccessTimes() + 1;
            calculateScore.calculate();
            guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator(), calculateScore);
        }
        if (guessNumberGame.getStatus() == GameStatus.FAILED) {
            sucessTimes = 0;
            guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator(), calculateScore);
        }
        calculateScore.setSuccessTimes(sucessTimes);
        calculateScore.setUserScore(userScore);
        userInfoMap.put(userName, calculateScore);
        map.put("userName", userName);
        map.put("userScore", userScore);
        map.put("input", userAnswerString);
        map.put("sucessTimes", sucessTimes);
        map.put("result", result);
        map.put("answer",guessNumberGame.getAnswer().getAnswerNumbers());
        return map;
    }
}
