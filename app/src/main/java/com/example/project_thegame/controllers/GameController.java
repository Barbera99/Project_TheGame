package com.example.project_thegame.controllers;


import com.example.project_thegame.models.Game;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    /**
     * Comprovem la puntuació.
     */
    public void check_score(){
        //TODO
    }
    /**
     * Passem a la següent ronda.
     */
    public void next_round(){
        //TODO
    }
    /**
     * Començem la partida.
     */
    public void start_game(){
        //TODO
    }
    /**
     * Comprovem si algun dels jugadors a assolit el nombre de victories mínimes per a guanyar la partia.
     */
    public boolean check_winner(){
        if(game.getScore_player1() >= 3 || game.getScore_player2() >= 3) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Escollirem un dels diferents mapes per cada ronda.
     */
    public void choose_map(){
        //TODO
    }

}
