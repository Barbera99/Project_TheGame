package com.example.project_thegame.service;

import com.example.project_thegame.models.Account;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AccountService {
    @POST("account/create_token")
    Call<Account> createTokenUser(@Header("Authorization") String authorizationToken);
    @GET("account/profile")
    Call<Account> getUserProfile(@Query("id") int id_user);
}
