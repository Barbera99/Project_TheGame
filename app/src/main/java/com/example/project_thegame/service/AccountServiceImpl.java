package com.example.project_thegame.service;

import com.example.project_thegame.models.Account;
import com.example.project_thegame.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class AccountServiceImpl implements AccountService {

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Account> createTokenUser(String authorizationToken) {
        return  retrofit.create(AccountService.class).createTokenUser(authorizationToken);
    }
    public Call<Account> getUserProfile(int id_user) {
        return  retrofit.create(AccountService.class).getUserProfile(id_user);
    }
}
