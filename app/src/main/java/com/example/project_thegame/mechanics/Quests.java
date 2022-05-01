package com.example.project_thegame.mechanics;

import com.example.project_thegame.models.Player;

import java.util.ArrayList;

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
