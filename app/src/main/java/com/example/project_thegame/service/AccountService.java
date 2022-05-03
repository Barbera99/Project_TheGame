package com.example.project_thegame.service;

import android.accounts.Account;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AccountService {
    @POST("account/create_token")
    Call<Account> createTokenUser(@Header("Authorization") String authorizationToken);
}
