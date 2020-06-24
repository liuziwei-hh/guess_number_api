package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class CalculateScoreTest {
    @Test
    public void should_return_2_when_input_1234_given_answer_1234() {
        Answer answer = new Answer(Arrays.asList("1", "2", "3", "4"));

        String result = answer.check(Arrays.asList("1", "2", "3", "4"));

        Assert.assertEquals("4A0B", result);
    }
}
