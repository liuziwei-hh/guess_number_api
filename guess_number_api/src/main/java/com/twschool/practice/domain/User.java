package com.twschool.practice.domain;

public class User {

    private String userId;
    private CalculateScore calculateScore;

    public User(String userId){
       this.userId=userId;
       this.calculateScore=new CalculateScore();
    }
    public void win(){
        this.calculateScore.increaseScore();
    }

    public void lose(){
        this.calculateScore.decreaseScore();
    }

    public int getscore(){
        return this.calculateScore.getScore();
    }
}
