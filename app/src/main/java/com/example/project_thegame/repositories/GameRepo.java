package com.example.project_thegame.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.helpers.ApiCallBack;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.service.DeckService;
import com.example.project_thegame.service.GameService;
import com.example.project_thegame.service.GameServiceImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GameRepo {
    private static String TAG = "GameRepo";
    private GameService gameService;
    public MutableLiveData<Game> startGame;
    public MutableLiveData<List> playerDecks;

    public GameRepo(){
        this.gameService = new GameServiceImpl();

    }

    public void startGame(int user_id, Game game){
        gameService.createGame(user_id, game).enqueue(new ApiCallBack<Game>() {
            @Override
            public void onFailure(Call call, Throwable t) {

            }

            @Override
            public void onResponseSuccess(Call<Game> call, Response<Game> response) {

            }

            @Override
            public void onResponseError(Call<Game> call, Throwable t) {

            }
        });
    }


    public void endGame(int game_id){
        gameService.endGame(game_id).enqueue(new ApiCallBack<Game>() {
            @Override
            public void onFailure(Call call, Throwable t) {

            }

            @Override
            public void onResponseSuccess(Call<Game> call, Response<Game> response) {

            }

            @Override
            public void onResponseError(Call<Game> call, Throwable t) {

            }
        });

    }
}
