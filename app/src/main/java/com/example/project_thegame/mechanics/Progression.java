package com.example.project_thegame.mechanics;


public class Progression {

    private int lvl;
    private int expForNextLvl;


    public Progression(){
        lvl = 0;
        expForNextLvl = 0;
    }
    public void lvlUp(){
        lvl++;
        expForNextLvl = 0;
    }


}
