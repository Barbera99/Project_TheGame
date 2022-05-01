package com.example.project_thegame.mechanics;

public class Quests {

    private String questName;
    private String difficulty;
    private int timeLimit;

    public Quests(String qName, String diff, int i){
        questName = qName;
        difficulty = diff;
        timeLimit = i;
    }
}
