package com.example.project_thegame.models;

import java.util.Date;

public class Game {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private int player_id_1;
    private int player_id_2;
    private int score_player1;
    private int score_player2;
    private Date date;


    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayer_id_1() {
        return player_id_1;
    }

    public void setPlayer_id_1(int player_id_1) {
        this.player_id_1 = player_id_1;
    }

    public int getPlayer_id_2() {
        return player_id_2;
    }

    public void setPlayer_id_2(int player_id_2) {
        this.player_id_2 = player_id_2;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
