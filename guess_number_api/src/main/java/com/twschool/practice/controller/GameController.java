package com.twschool.practice.controller;

import com.twschool.practice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/game")
    public Map<String, Object> answer(@RequestParam String userName, @RequestParam String guess) {
        Map<String, Object> map = gameService.guess(userName, guess);

        return map;
    }

    @GetMapping("/user")
    public Map<String, String> score(@RequestParam String guess) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("input", guess);
        map.put("result", "4A0B");
        return map;
    }
}
