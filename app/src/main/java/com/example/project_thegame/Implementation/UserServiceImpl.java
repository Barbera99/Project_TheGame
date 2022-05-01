package com.example.project_thegame.Implementation;

import com.example.project_thegame.Interfaces.UserService;
import com.example.project_thegame.Network.RetrofitClientInstance;
import com.example.project_thegame.models.User;

import retrofit2.Call;
import retrofit2.Retrofit;

public class UserServiceImpl implements UserService{
    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    public Call<User> getUserByUsername(String username) {
        return retrofit.create(UserService.class).getUserByUsername(username);
    }
}
