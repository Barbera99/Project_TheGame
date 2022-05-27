package com.example.project_thegame.service;

import com.example.project_thegame.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("/user/{user_id}")
    Call<User> getUserById(@Path("user_id") int user_id);
    @POST("/user/register")
    Call<ResponseBody> createUser(@Body User user);
}
