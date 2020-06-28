package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class CalculateScoreTest {
    @Test
    public void should_return_0_when_get_point_with_init_Integration() {
        CalculateScore calculateScore = new CalculateScore();
        Assert.assertEquals(0, calculateScore.getScore());
    }

    @Test
    public void should_return_3_when_execute_method_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        executeIncreaseScoreBySucessTimes(calculateScore, 1);
        Assert.assertEquals(3, calculateScore.getScore());
    }

    @Test
    public void should_return_11_when_execute_3_times_method_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        executeIncreaseScoreBySucessTimes(calculateScore, 3);
        Assert.assertEquals(11, calculateScore.getScore());
    }

    @Test
    public void should_return_20_when_execute_5_times_method_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        executeIncreaseScoreBySucessTimes(calculateScore, 5);
        Assert.assertEquals(20, ((CalculateScore) calculateScore).getScore());
    }

    @Test
    public void should_return_31_when_execute_8_times_method_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        executeIncreaseScoreBySucessTimes(calculateScore, 8);
        Assert.assertEquals(31, calculateScore.getScore());
    }

    @Test
    public void should_return_40_when_execute_10_times_method_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        executeIncreaseScoreBySucessTimes(calculateScore, 10);
        Assert.assertEquals(40, calculateScore.getScore());
    }

    @Test
    public void should_return_burden_3_when_execute_subPoint() {
        CalculateScore calculateScore = new CalculateScore();
        calculateScore.decreaseScore();
        Assert.assertEquals(-3, calculateScore.getScore());
    }

    @Test
    public void should_return_6_when_execute_2_times_addPoint_and_execute_subPoint_and_execute_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        calculateScore.increaseScore();
        calculateScore.increaseScore();
        calculateScore.decreaseScore();
        calculateScore.increaseScore();
        Assert.assertEquals(6, calculateScore.getScore());
    }

    @Test
    public void should_return_14_when_execute_2_times_addPoint_and_execute_subPoint_and_execute_3_times_addPoint() {
        CalculateScore calculateScore = new CalculateScore();
        calculateScore.increaseScore();
        calculateScore.increaseScore();
        calculateScore.decreaseScore();
        calculateScore.increaseScore();
        calculateScore.increaseScore();
        calculateScore.increaseScore();
        Assert.assertEquals(14, calculateScore.getScore());
    }

    private void executeIncreaseScoreBySucessTimes(CalculateScore calculateScore, int sucessTimes) {
        for (int i = 0; i < sucessTimes; i++) {
            calculateScore.increaseScore();
        }
    }
}
