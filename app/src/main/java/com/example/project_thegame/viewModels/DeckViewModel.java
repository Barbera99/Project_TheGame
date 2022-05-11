package com.example.project_thegame.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.repositories.DeckRepo;

public class DeckViewModel extends ViewModel {
    public MutableLiveData<Deck> currentDeck;
    private final DeckRepo deckRepo;
    public MutableLiveData<Card> card1;
    public MutableLiveData<Card> card2;
    public MutableLiveData<Card> card3;
    public MutableLiveData<Card> card4;
    public MutableLiveData<Card> card5;

    public DeckViewModel(){
        this.currentDeck = new MutableLiveData<Deck>();
        this.deckRepo = new DeckRepo();

    }

    public void getUserDecks(int user_id){
        this.deckRepo.getPlayerDecks(user_id);
    }

    public void getDeck(int id_deck){

        this.deckRepo.getDeck(id_deck);
    }

    public void LoadDeck(){

    }


    /* GETTERS I SETTERS */
    public MutableLiveData<Deck> getCurrentDeck() {
        return currentDeck;
    }

    public void setCurrentDeck(MutableLiveData<Deck> currentDeck) {
        this.currentDeck = currentDeck;
    }

    public DeckRepo getDeckRepo() {
        return deckRepo;
    }
}
