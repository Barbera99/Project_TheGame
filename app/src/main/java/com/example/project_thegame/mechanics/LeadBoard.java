package com.example.project_thegame.mechanics;

import com.example.project_thegame.models.Player;

import java.util.ArrayList;

public class LeadBoard {

    private int id;
    private String typeOfLeadBoard;
    private ArrayList<Player> listPlayers;

    private ArrayList<Integer> topScores;



    public LeadBoard(int i){
        id = i;
        listPlayers = new ArrayList<>();
    }
    public Player getMaxLeader(){
        return listPlayers.get(0);
    }
}
