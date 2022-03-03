package com.example.project_thegame.mechanics;
import java.util.ArrayList;

public class Achievements {

	private ArrayList<String> listOfAchievements;
	private boolean[] ifUnlocked;
    public Achievements(ArrayList<String> list){
        listOfAchievements = list;
		ifUnlocked = new boolean[listOfAchievements.size()];
    }
}
