package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.helpers.ApiCallBack;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Result;
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
    private Result<Integer> createGameResult;
    private MutableLiveData<Result<Integer>> createGameResultLiveData;


    public GameRepo(){
        this.gameService = new GameServiceImpl();
        createGameResultLiveData = new MutableLiveData<>();

    }

    public void createGame(int user_id, Game game){
        gameService.createGame(user_id, game).enqueue(new ApiCallBack<Game>() {
            @Override
            public void onFailure(Call call, Throwable t) {
                createGameResult = Result.error(t);
                createGameResultLiveData.postValue(createGameResult);
                Log.d(TAG, "createGame() -> onFailure -> " + t.getMessage());
            }

            @Override
            public void onResponseSuccess(Call<Game> call, Response<Game> response) {
                Log.d(TAG, "register() -> onResponseSusccess -> " + response.code());
                int code = response.code();
                if (code == 200) {
                    createGameResult.setIsRegisteredLiveData(new MutableLiveData<Boolean>(true));
                }
            }

            @Override
            public void onResponseError(Call<Game> call, Throwable t) {
                createGameResult = Result.error(t);
                createGameResultLiveData.postValue(createGameResult);
                Log.d(TAG, "createGame() -> onResponseError -> " + t.getMessage());

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
