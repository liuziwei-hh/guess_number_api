package com.twschool.practice.controller;

import com.twschool.practice.domain.User;
import com.twschool.practice.service.GuessGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@RestController
public class GuessGameController {

    @Autowired
    private GuessGameService guessGameService;

    @RequestMapping("/guessGame")
    public Map<String, String> guessGame(@RequestParam("input") String input) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("input", input);
        resultMap.put("result", guessGameService.guess(input));
        return resultMap;
    }

    @RequestMapping("/game/start")
    public Map<String, String> guessGameStartByUser(@RequestParam("id") String id) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("isNewUser", String.valueOf(guessGameService.startGame(id)));
        resultMap.put("userId", id);
        return resultMap;
    }

    @RequestMapping("/game/guess")
    public Map<String, String> guessGameByUser(@RequestParam("id") String id, @RequestParam("input") String input) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("userId", id);
        resultMap.put("input", input);
        resultMap.put("isExistUser", String.valueOf(!guessGameService.isExistUser(id)));
        resultMap.put("result", guessGameService.guess(id, input));
        return resultMap;
    }

    @RequestMapping("/getUser")
    public Map<String, String> getUser(@RequestParam("id") String id) {
        Map<String, String> resultMap = new HashMap<>();
        User user = guessGameService.getUser(id);
        if (user == null) {
            resultMap.put("user", "is not exist");
        }else {
            resultMap.put("id", user.toString());
            resultMap.put("point", String.valueOf(user.getscore()));
        }
        return resultMap;
    }
}
