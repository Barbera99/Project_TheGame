package com.example.project_thegame.service;

import com.example.project_thegame.models.Game;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GameService {

    @POST("/game/start/{user_id}")
    Call<ResponseBody> createGame (@Path("user_id") int user_id, @Body Game game);

}
