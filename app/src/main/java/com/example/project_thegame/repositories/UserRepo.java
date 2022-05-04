package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.helpers.ApiCallBack;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.service.UserServiceImpl;
import com.example.project_thegame.service.UserService;
import com.example.project_thegame.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserRepo {
    private static String TAG = "UserRepo";
    private UserService userService;
    private Result<Integer> registerResult;
    private MutableLiveData<Result<Integer>> registerResultLiveData;
    public MutableLiveData<User> mplayer;

    public UserRepo() {
        this.userService = new UserServiceImpl();
        this.mplayer = new MutableLiveData<>();
        registerResultLiveData = new MutableLiveData<>();
    }

    public void getUserByUsername(String username){
        userService.getUserByUsername(username).enqueue(
                new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        int code = response.code();
                        if (code == 200) {
                            User u = response.body();
                            assert u != null;
                            mplayer.setValue(u); // Setting the MUTABLE!!!!!!
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }

    public void registerUser(User user) {
        this.userService.createUser(user).enqueue(new ApiCallBack<User>() {

            @Override
            public void onFailure(Call call, Throwable t) {
                registerResult = Result.error(t);
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "register() -> onResponseError -> " + t.getMessage());
            }

            @Override
            public void onResponseSuccess(Call<User> call, Response<User> response) {
                Log.d(TAG, "Int response");
                Log.d(TAG, "register() -> onResponseSuccess -> " + response.body().toString());
                int id_user = response.body().getId();
                Log.d(TAG, "register() -> onResponseSuccess -> " + id_user);
                registerResult = Result.success(id_user);
                Log.d(TAG, "register() -> onResponseSuccess / getResult-> " + registerResult.getResult());
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "register() -> onResponseSuccess END");
            }

            @Override
            public void onResponseError(Call<User> call, Throwable t) {
                registerResult = Result.error(t);
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "register() -> onResponseError -> " + t.getMessage());
            }
        });
    }
}
