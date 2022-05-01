package com.example.project_thegame.Interfaces;

import com.example.project_thegame.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("/user/{username}")
    Call<User> getUserByUsername(@Query("username") String username);

}
