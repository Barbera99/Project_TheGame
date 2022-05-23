package com.example.project_thegame.repositories;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.models.Deck;
import com.example.project_thegame.service.DeckService;
import com.example.project_thegame.service.DeckServiceImpl;
import com.example.project_thegame.viewModels.DeckViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeckRepo {
    private static String TAG = "DeckRepo";
    private DeckService deckService;
    public MutableLiveData<Deck> playerDeck;
    public MutableLiveData<List> playerDecks;
    private DeckViewModel deckViewModel;

    public DeckRepo(){
        this.deckService = new DeckServiceImpl();
        playerDeck = new MutableLiveData<Deck>();
        playerDecks = new MutableLiveData<List>();
    }

    public void getDeck (Integer deck_id){
        deckService.getDeck(deck_id).enqueue(
                new Callback<Deck>() {
                    @Override
                    public void onResponse(Call<Deck> call, Response<Deck> response) {
                        int code = response.code();
                        if(code == 200){
                            assert response.body() != null;
                            playerDeck.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Deck> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                }
        );
    }

    public void getPlayerDecks (Integer user_id){
        deckService.getPlayerDecks(user_id).enqueue(
                new Callback<List<Deck>>() {
                    @Override
                    public void onResponse(Call<List<Deck>> call, Response<List<Deck>> response) {
                        int code = response.code();
                        if(code == 200){
                            assert response.body() != null;
                            playerDecks.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Deck>> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                }
        );
    }

    public void setDeckViewModel(DeckViewModel deckViewModel){
        this.deckViewModel = deckViewModel;
    }
}
