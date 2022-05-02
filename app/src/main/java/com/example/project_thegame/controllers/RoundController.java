package com.example.project_thegame.controllers;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.User;
import com.example.project_thegame.models.Round;

public class RoundController {
    public Round round;

    public RoundController(Round r){
        round = r;
    }

    /**
     * Comprovarem el guanyador de la ronda.
     */
    public void check_round_score(){

        /*round.getPlayer1();
        if(player1card.getSpeed() > player2card.getSpeed()) {
            System.out.println("Ha guanyat el jugador 1");
            player1score++;
        } else if(player1card.getSpeed() < player2card.getSpeed()) {
            System.out.println("Ha guanyat el jugador 2");
            player2score++;
        }*/
    }

}
