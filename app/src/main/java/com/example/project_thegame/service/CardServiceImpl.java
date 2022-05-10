package com.example.project_thegame.service;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CardServiceImpl implements CardService {
    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    public Call<Card> getCard (Integer card_id) {
        return retrofit.create(CardService.class).getCard(card_id);
    }
}
