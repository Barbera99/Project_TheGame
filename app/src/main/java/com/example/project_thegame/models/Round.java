package com.example.project_thegame.models;

public class Round {
    /**
     * Declaració dels atributs de classe.
     */
    private int number;
    private Map map;
    private Player player1;
    private Player player2;

    /**
     * Declaració dels getters i setters.
     *
     */
    public int getNumber() { return number; }
    public void setNumber(int number) {
        this.number = number;
    }
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public Player getPlayer1() {
        return player1;
    }
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
