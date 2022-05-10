package com.example.project_thegame.service;

import com.example.project_thegame.models.Deck;
import com.example.project_thegame.network.RetrofitClientInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;

public class DeckServiceImpl implements DeckService {

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    public Call<Deck> getDeck(Integer deck_id) {
        return retrofit.create(DeckService.class).getDeck(deck_id);
    }

    public Call<List<Deck>> getPlayerDecks(Integer user_id) {
        return retrofit.create(DeckService.class).getPlayerDecks(user_id);
    }
}
