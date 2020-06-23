package com.twschool.practice.controller;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.service.GuessGameService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Map;

public class GuessGameServiceTest {

    @Test
    public void should_return_4A0B_when_given_answer_1234_and_input_1234() {
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(new Answer(Arrays.asList(new String[]{"1", "2", "3", "4"})));
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        GuessGameService guessGameService = new GuessGameService();
        Map<String, Object> result = guessGameService.guess("1111","1 2 3 4");
        Assert.assertEquals(result, "4A0B");
    }
}
