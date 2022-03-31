package com.example.project_thegame.mechanics;

import com.example.project_thegame.models.User;

import java.util.ArrayList;

public class Relationship {
    private ArrayList<User> listOfFriends;
    private ArrayList<User> listOfBlocks;

    public Relationship(){
        listOfFriends = new ArrayList<>();
        listOfBlocks = new ArrayList<>();
    }

    public void addFriend(User p){
        this.listOfFriends.add(p);
    }
    public void deleteFriend(User p){
        this.listOfFriends.remove(p);
    }
    public void addBlock(User p){
        this.listOfBlocks.add(p);
    }
    public void undoBlock(User p){
        this.listOfBlocks.remove(p);
    }
}
