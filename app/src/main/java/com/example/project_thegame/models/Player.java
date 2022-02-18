package com.example.project_thegame.models;

public class Player {
    /**
     * Declaració dels atributs de classe.
     */
    private String name;
    private int games_played;
    private int wins;
    private int defeats;
    private int achivements;
    private int owned_cards;

    /**
     * Declaració dels getters i setters.
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getAchivements() {
        return achivements;
    }

    public void setAchivements(int achivements) {
        this.achivements = achivements;
    }

    public int getOwned_cards() {
        return owned_cards;
    }

    public void setOwned_cards(int owned_cards) {
        this.owned_cards = owned_cards;
    }
}
