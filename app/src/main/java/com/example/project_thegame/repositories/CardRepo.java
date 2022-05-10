package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.service.CardService;
import com.example.project_thegame.service.CardServiceImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardRepo {
    private static String TAG = "CardRepo";
    private CardService cardService;
    public MutableLiveData<Card> card;

    public CardRepo(){
        cardService = new CardServiceImpl();
        card = new MutableLiveData<Card>();
    }

    public void getCard(Integer card_id){
        cardService.getCard(card_id).enqueue(
                new Callback<Card>() {
                    @Override
                    public void onResponse(Call<Card> call, Response<Card> response) {
                        int code = response.code();
                        if(code == 200){
                            assert response.body() != null;
                            card.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Card> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                }
        );

    }
}
