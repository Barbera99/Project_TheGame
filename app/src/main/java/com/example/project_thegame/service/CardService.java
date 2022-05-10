package com.example.project_thegame.service;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CardService {
    @GET("/card/{card_id}")
    Call<Card> getCard(@Query("card_id") Integer card_id);
}
