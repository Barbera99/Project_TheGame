package com.example.project_thegame.models;

public class Game {
    /**
     * Declaració dels atributs de classe.
     */
    private Map map1;
    private Map map2;
    private Map map3;
    private Map map4;
    private Map map5;
    private User player1;
    private User player2;
    private Map []already_played;
    private int score_player1;
    private int score_player2;

    public Game(User player1, User player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.score_player1 = 0;
        this.score_player2 = 0;
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public Map getMap1() {
        return map1;
    }

    public void setMap1(Map map1) {
        this.map1 = map1;
    }

    public Map getMap2() {
        return map2;
    }

    public void setMap2(Map map2) {
        this.map2 = map2;
    }

    public Map getMap3() {
        return map3;
    }

    public void setMap3(Map map3) {
        this.map3 = map3;
    }

    public Map getMap4() {
        return map4;
    }

    public void setMap4(Map map4) {
        this.map4 = map4;
    }

    public Map getMap5() {
        return map5;
    }

    public void setMap5(Map map5) {
        this.map5 = map5;
    }

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
