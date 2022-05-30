package com.example.project_thegame.models;

import com.google.gson.annotations.SerializedName;

public class Game {
    /**
     * Declaració dels atributs de classe.
     */
    @SerializedName("game_id")
    private int game_id;
    @SerializedName("user1_id")
    private int player1_id;
    @SerializedName("user2_id")
    private int player2_id;
    @SerializedName("user1_score")
    private int score_player1;
    @SerializedName("user2_score")
    private int score_player2;

    private Map []already_played;


    public Game(int player1, int player2, int score_player1, int score_player2) {
        this.player1_id = player1;
        this.player2_id = player2;
        this.score_player1 = score_player1;
        this.score_player2 = score_player2;
    }

    public Game(int player1, int player2) {
        this.player1_id = player1;
        this.player2_id = player2;
        this.score_player1 = 0;
        this.score_player2 = 0;
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public int getGameId() {
        return game_id;
    }

    public int getPlayer1Id() {
        return player1_id;
    }

    public void setPlayer1Id(int player1) {
        this.player1_id = player1;
    }

    public int getPlayer2Id() {
        return player2_id;
    }

    public void setGameId(int game_id) {
        this.game_id = game_id;
    }

    public void setPlayer2(int player2) {
        this.player2_id = player2;
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
