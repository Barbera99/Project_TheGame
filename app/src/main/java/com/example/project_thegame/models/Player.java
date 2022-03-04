package com.example.project_thegame.models;

import java.util.ArrayList;

public class Player {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String name;
    private int games_played;
    private int wins;
    private int defeats;
    private Deck playerDeck;
    private ArrayList<Card> listOfCardsOwned;

    /**
     * CONSTRUCTOR
     *
     */
    public Player(int id, String name, int games_played, int wins, int defeats, Deck playerDeck) {
        this.id = id;
        this.name = name;
        this.games_played = games_played;
        this.wins = wins;
        this.defeats = defeats;
        this.playerDeck = playerDeck;
        this.listOfCardsOwned = new ArrayList<>();
    }

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

    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //altres
    // public static Player getPlayerById(int id) {}
}
