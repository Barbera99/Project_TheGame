package com.example.project_thegame.mechanics;

public class Points {

    private int points;

    public Points(){
        points = 0;
    }

    public void addPoints(int i){
        points = points + i;
    }
    public void removePoints(int i){
        if((points - i) <= 0){
            points = 0;
        } else {
            points = points - i;
        }
    }

}
