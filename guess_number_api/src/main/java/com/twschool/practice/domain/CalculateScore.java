package com.twschool.practice.domain;

public class CalculateScore {
    private static final int INIT_WIN_BOUNS_COUNT = 0;
    private static final int ONCE_ADD_STEP = 3;
    private static final int ONCE_SUB_STEP = -3;
    private static final int THREE_TIMES_WIN_BOUNS_COUNT = 3;
    private static final int THREE_TIMES_WIN_BOUNS_POINT = 2;
    private static final int FIVE_TIMES_WIN_BOUNS_COUNT = 5;
    private static final int FIVE_TIMES_WIN_BOUNS_POINT = 3;

    private int sucessTimes = INIT_WIN_BOUNS_COUNT;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        this.score += ONCE_ADD_STEP;
        if (++sucessTimes == THREE_TIMES_WIN_BOUNS_COUNT) {
            this.score += THREE_TIMES_WIN_BOUNS_POINT;
        } else if (sucessTimes == FIVE_TIMES_WIN_BOUNS_COUNT) {
            this.score += FIVE_TIMES_WIN_BOUNS_POINT;
            this.sucessTimes = INIT_WIN_BOUNS_COUNT;
        }
    }

    public void decreaseScore() {
        this.score += ONCE_SUB_STEP;
        this.sucessTimes = INIT_WIN_BOUNS_COUNT;
    }}
