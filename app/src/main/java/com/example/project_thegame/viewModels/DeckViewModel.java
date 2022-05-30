package com.example.project_thegame.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.repositories.DeckRepo;
import com.example.project_thegame.views.GameActivity;

public class DeckViewModel extends ViewModel {
    public MutableLiveData<Deck> currentDeck;
    private final DeckRepo deckRepo;

    public DeckViewModel(){
        this.currentDeck = new MutableLiveData<Deck>();
        this.deckRepo = new DeckRepo();
        deckRepo.setDeckViewModel(this);
    }
}
