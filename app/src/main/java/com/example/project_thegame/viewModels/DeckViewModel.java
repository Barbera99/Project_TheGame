package com.example.project_thegame.viewModels;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Player;

import java.util.ArrayList;

public class DeckViewModel {

    Player player;
    Deck deck;
    public DeckViewModel(){
        deck = new Deck();
    }
    public ArrayList<Card> getCards(){
        return this.player.getListOfCardsOwned();
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p){
        this.player = p;
    }

    public ArrayList<String> updateList(Card c){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Nombre:"+c.getName());
        arrayList.add("Fuerza:"+c.getStrenght());
        arrayList.add("Velocidad:"+c.getSpeed());
        arrayList.add("Agilidad:"+c.getAgility());
        arrayList.add("Aguante:"+c.getEndurance());
        arrayList.add("Inteligencia:"+c.getIntelligencie());
        arrayList.add("Categoria:"+c.getCategory());
        return arrayList;
    }
    public void updateDeck(Card[] vectCard){
        deck.setArrayDeck(vectCard);
        player.setPlayerDeck(deck);
    }
}
