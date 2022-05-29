package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.helpers.ApiCallBack;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.models.User;
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
    public MutableLiveData<Boolean> gameSaved;
    public MutableLiveData<Result<String>> saveGameLiveData;
    private Result<Integer> saveGameResult;
    private GameViewModel gameViewModel;

    public GameRepo(){
        this.gameService = new GameServiceImpl();
        saveGameLiveData = new MutableLiveData<>();
    }

    public void saveGame(int user_id, Game game){
        this.gameService.saveGame(user_id, game).enqueue(new ApiCallBack<Game>() {
            @Override
            public void onFailure(Call call, Throwable t) {
                saveGameResult = Result.error(t);
                gameSaved.setValue(false);
                Log.d(TAG, "saveGame() -> onFailure -> " + t.getMessage());
            }

            @Override
            public void onResponseSuccess(Call<Game> call, Response<Game> response) {
                int code = response.code();
                if (code == 200) {
                    gameViewModel.isGameEnded.setValue(true);
                }
            }

            @Override
            public void onResponseError(Call<Game> call, Throwable t) {
                saveGameResult = Result.error(t);
                gameSaved.setValue(false);
                Log.d(TAG, "saveGame() -> onFailure -> " + t.getMessage());
            }
        });
    }

     public void setGameViewModel(GameViewModel gameViewModel){
        this.gameViewModel = gameViewModel;
     }
}
