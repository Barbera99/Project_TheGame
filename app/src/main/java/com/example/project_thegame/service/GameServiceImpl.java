package com.example.project_thegame.service;

import com.example.project_thegame.models.Game;
import com.example.project_thegame.network.RetrofitClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class GameServiceImpl implements GameService{
    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<ResponseBody> createGame(int user_id, Game game) {
        return retrofit.create(GameService.class).createGame(user_id, game);
    }

}
