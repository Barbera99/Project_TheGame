package com.example.project_thegame.mechanics;

import com.example.project_thegame.models.User;

import java.util.ArrayList;

public class LeadBoard {

    private int id;
    private String typeOfLeadBoard;
    private ArrayList<User> listUsers;

    private ArrayList<Integer> topScores;



    public LeadBoard(int i){
        id = i;
        listUsers = new ArrayList<>();
    }
    public User getMaxLeader(){
        return listUsers.get(0);
    }
}
