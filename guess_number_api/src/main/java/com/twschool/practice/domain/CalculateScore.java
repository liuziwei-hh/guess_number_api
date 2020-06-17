package com.twschool.practice.domain;

public class CalculateScore {
private int userScore;
private int successTimes;

    public CalculateScore(int userScore, int successTimes) {
        userScore = userScore;
        this.successTimes = successTimes;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getSuccessTimes() {
        return successTimes;
    }

    public void setSuccessTimes(int successTimes) {
        this.successTimes = successTimes;
    }

    public int calculate() {
       if (successTimes % 3 == 0) {
           userScore += 2;
       }
       if (successTimes % 5 == 0) {
           userScore += 3;
       }
       return userScore;
   }
}
