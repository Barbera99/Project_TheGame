package com.example.project_thegame.models;

public class Stats {
    private int id;
    private int games_Played;
    private int ranked_Wins;
    private int ranked_Defeats;
    private int normal_Wins;
    private int normal_Defeats;
    private int level;
    private int medals;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGames_Played() {
        return games_Played;
    }

    public void setGames_Played(int games_Played) {
        this.games_Played = games_Played;
    }

    public int getRanked_Wins() {
        return ranked_Wins;
    }

    public void setRanked_Wins(int ranked_Wins) {
        this.ranked_Wins = ranked_Wins;
    }

    public int getRanked_Defeats() {
        return ranked_Defeats;
    }

    public void setRanked_Defeats(int ranked_Defeats) {
        this.ranked_Defeats = ranked_Defeats;
    }

    public int getNormal_Wins() {
        return normal_Wins;
    }

    public void setNormal_Wins(int normal_Wins) {
        this.normal_Wins = normal_Wins;
    }

    public int getNormal_Defeats() {
        return normal_Defeats;
    }

    public void setNormal_Defeats(int normal_Defeats) {
        this.normal_Defeats = normal_Defeats;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMedals() {
        return medals;
    }

    public void setMedals(int medals) {
        this.medals = medals;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
