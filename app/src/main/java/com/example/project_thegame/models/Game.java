package com.example.project_thegame.models;

public class Game {
    private Player player;
    private Player ia;

    public Player getPlayer() {
        return player;
    }

    public Player getIa() {
        return ia;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setIa(Player ia) {
        this.ia = ia;
    }
}
