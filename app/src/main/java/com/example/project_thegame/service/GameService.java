package com.example.project_thegame.service;

import com.example.project_thegame.models.Game;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface GameService {

    @POST("/game/start/{user_id}")
    Call<ResponseBody> createGame (@Body Game game);

    @PUT("/game/end/{game_id}")
    Call<ResponseBody> endGame (@Query("game_id") int game_id);
}
