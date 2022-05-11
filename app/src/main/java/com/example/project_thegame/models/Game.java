package com.example.project_thegame.models;

public class Game {
    /**
     * Declaració dels atributs de classe.
     */

    private User player1;
    private User player2;
    private Map []already_played;
    private int score_player1;
    private int score_player2;

    public Game(User player1, User player2, Map [] already_played) {
        this.player1 = player1;
        this.player2 = player2;
        this.score_player1 = 0;
        this.score_player2 = 0;
        this.already_played = already_played;
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
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
