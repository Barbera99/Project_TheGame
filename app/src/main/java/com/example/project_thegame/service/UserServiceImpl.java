package com.example.project_thegame.service;

import com.example.project_thegame.network.RetrofitClientInstance;
import com.example.project_thegame.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class UserServiceImpl implements UserService{
    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    public Call<User> getUserById(int user_id) {
        return retrofit.create(UserService.class).getUserById(user_id);
    }
    public Call<ResponseBody> createUser(User user) {
        return retrofit.create(UserService.class).createUser(user);
    }
}
