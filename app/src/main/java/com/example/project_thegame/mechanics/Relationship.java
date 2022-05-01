package com.example.project_thegame.mechanics;

import com.example.project_thegame.models.Player;

import java.util.ArrayList;

public class Relationship {
    private ArrayList<Player> listOfFriends;
    private ArrayList<Player> listOfBlocks;

    public Relationship(){
        listOfFriends = new ArrayList<>();
        listOfBlocks = new ArrayList<>();
    }

    public void addFriend(Player p){
        this.listOfFriends.add(p);
    }
    public void deleteFriend(Player p){
        this.listOfFriends.remove(p);
    }
    public void addBlock(Player p){
        this.listOfBlocks.add(p);
    }
    public void undoBlock(Player p){
        this.listOfBlocks.remove(p);
    }
}
