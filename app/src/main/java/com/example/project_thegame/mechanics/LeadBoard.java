package com.example.project_thegame.mechanics;

import com.example.project_thegame.models.User;

import java.util.ArrayList;

public class LeadBoard {

    private int id;
    private String typeOfLeadBoard;
    private ArrayList<User> listPlayers;

    private ArrayList<Integer> topScores;



    public LeadBoard(int i){
        id = i;
        listPlayers = new ArrayList<>();
    }
    public User getMaxLeader(){
        return listPlayers.get(0);
    }
}
