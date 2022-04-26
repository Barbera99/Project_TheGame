package com.example.project_thegame.models;

public class Rank {
    private int id;
    private String league;
    private int min_medals;
    private int max_medals;
    public Rank(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getMin_medals() {
        return min_medals;
    }

    public void setMin_medals(int min_medals) {
        this.min_medals = min_medals;
    }

    public int getMax_medals() {
        return max_medals;
    }

    public void setMax_medals(int max_medals) {
        this.max_medals = max_medals;
    }
}
