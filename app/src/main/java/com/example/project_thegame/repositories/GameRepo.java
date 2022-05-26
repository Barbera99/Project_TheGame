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
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.viewModels.GameViewModel;

import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class GameRepo {
    private static String TAG = "GameRepo";
    private GameService gameService;
    public MutableLiveData<Boolean> gameStarted;
    public MutableLiveData<Boolean> gameEnded;
    public MutableLiveData<Result<String>> createGameLiveData;
    private Result<Integer> createGameResult;
    private Result<Integer> endGameResult;
    private GameViewModel gameViewModel;

    public GameRepo(){
        this.gameService = new GameServiceImpl();
        createGameLiveData = new MutableLiveData<>();

    }

    public void createGame(int user_id, Game game){
        this.gameService.createGame(user_id, game).enqueue(new ApiCallBack<Game>() {
            @Override
            public void onFailure(Call call, Throwable t) {
                createGameResult = Result.error(t);
                gameStarted.setValue(false);
                Log.d(TAG, "createGame() -> onFailure -> " + t.getMessage());
            }

            @Override
            public void onResponseSuccess(Call<Game> call, Response<Game> response) {
                int game_id = response.body().getGameId();
                Log.d(TAG, "createGame() -> game_id -> " + game_id);
                PreferencesProvider.providePreferences().edit().putInt("game_id", game_id).commit();

                Log.d(TAG, "createGame() -> onResponseSusccess -> " + response.code());
            }

            @Override
            public void onResponseError(Call<Game> call, Throwable t) {
                createGameResult = Result.error(t);
                gameStarted.setValue(false);
                Log.d(TAG, "createGame() -> onFailure -> " + t.getMessage());
            }
        });
    }

     public void setGameViewModel(GameViewModel gameViewModel){
        this.gameViewModel = gameViewModel;
     }
}
