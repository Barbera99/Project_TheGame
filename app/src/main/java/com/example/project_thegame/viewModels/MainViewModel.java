package com.example.project_thegame.viewModels;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.User;

import java.util.ArrayList;

public class MainViewModel {

    public static Card carta1 = new Card(1, "Benito", 50, 26, 44, 86, 51, false, 2);
    public static Card carta2 = new Card(2, "Paco", 20, 24, 94, 12, 89, false, 3);
    public static Card carta3 = new Card(1, "Mariano", 30, 30, 36, 38, 5, false, 1);
    public static Card carta4 = new Card(2, "Raimundo", 69, 28, 95, 15, 36, false, 3);
    public static Card carta5 = new Card(1, "Jaime", 10, 98, 72, 11, 10, false, 3);
    public static Card carta6 = new Card(2, "Jose", 29, 59, 61, 46, 98, false, 3);
    public static Card carta7 = new Card(1, "Fran", 40, 57, 59, 85, 83, false, 2);
    public static Card carta8 = new Card(2, "Gonzalo", 19, 29, 39, 23, 9, false, 1);
    public static Card carta9 = new Card(1, "Jon", 5, 53, 24, 83, 16, false, 2);
    public static Card carta10 = new Card(2, "Carlos", 16, 32, 51, 14, 94, false, 2);
    ArrayList<Card> lCard = new ArrayList<Card>();
    User user;
    User IAplayer;
    Game game;
    public MainViewModel(){

        user = new User(1, "User", lCard);
    }

    public void setListCard(){
        lCard.add(carta1);
        lCard.add(carta2);
        lCard.add(carta3);
        lCard.add(carta4);
        lCard.add(carta5);
        lCard.add(carta6);
        lCard.add(carta7);
        lCard.add(carta8);
        lCard.add(carta9);
        lCard.add(carta10);
    }

    public ArrayList<Card> getlCard() {
        return lCard;
    }
    public int checkIfDeck(){
        int result = getPlayer().getPlayerDeck().getArrayDeck().size();
        return result;
    }
    public User getPlayer() {
        return user;
    }
    public void setPlayer(User p){
        this.user = p;
    }


}
