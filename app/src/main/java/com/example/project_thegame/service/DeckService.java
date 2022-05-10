package com.example.project_thegame.service;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.User;

import java.lang.reflect.Array;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DeckService {
    @GET("/deck/{deck_id}")
    Call<Deck> getDeck(@Query("deck_id") Integer deck_id);

    @GET("/decks/{user_id}")
    Call<List<Deck>> getPlayerDecks(@Query("user_id") Integer user_id);
}
