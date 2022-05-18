package com.example.project_thegame.service;

import com.example.project_thegame.models.Account;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AccountService {
    @POST("/account/create_token")
    Call<Account> createTokenUser(@Header("Authorization") String authorizationToken);
    @POST("/account/delete_token")
    Call<ResponseBody> deleteTokenUser(@Body String deleteToken);
}
