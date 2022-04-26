package com.example.project_thegame.models;

import java.util.ArrayList;

public class Game {
    /**
     * Declaració dels atributs de classe.
     */

    private User user1;
    private User user2;
    private Map []already_played;
    private int score_player1;
    private int score_player2;

    public Game(){
        this.user2 = new User(-1,"IA", new ArrayList<Card>());
    }
    public Game(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.score_player1 = 0;
        this.score_player2 = 0;
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */

    public User getPlayer1() {
        return user1;
    }

    public void setPlayer1(User user1) {
        this.user1 = user1;
    }

    public User getPlayer2() {
        return user2;
    }

    public void setPlayer2(User user2) {
        this.user2 = user2;
    }

    public Map[] getAlready_played() {
        return already_played;
    }

    public void setAlready_played(Map[] already_played) {
        this.already_played = already_played;
    }

    public int getScore_player1() {
        return score_player1;
    }

    public void setScore_player1(int score_player1) {
        this.score_player1 = score_player1;
    }

    public int getScore_player2() {
        return score_player2;
    }

    public void setScore_player2(int score_player2) {
        this.score_player2 = score_player2;
    }
}
