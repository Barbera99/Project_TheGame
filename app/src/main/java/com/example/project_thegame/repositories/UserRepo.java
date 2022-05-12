package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.LoginActivity;
import com.example.project_thegame.RegisterActivity;
import com.example.project_thegame.helpers.ApiCallBack;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.service.UserServiceImpl;
import com.example.project_thegame.service.UserService;
import com.example.project_thegame.models.User;
import com.example.project_thegame.viewModels.RegisterViewModel;

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
        userService.createUser(user).enqueue(new ApiCallBack<User>() {

            @Override
            public void onFailure(Call call, Throwable t) {
                registerResult = Result.error(t);
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "register() -> onFailure -> " + t.getMessage());
            }

            @Override
            public void onResponseSuccess(Call<User> call, Response<User> response) {
                registerResult = Result.success(response.body().getId());
                Log.d(TAG, "register() -> onResponseSusccess -> " + response.code());
                int code = response.code();
                if (code == 200) {
                    registerResultLiveData.postValue(registerResult);
                }
            }

            @Override
            public void onResponseError(Call<User> call, Throwable t) {
                registerResult = Result.error(t);
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "register() -> onResponseError -> " + t.getMessage());
            }
        });
    }

    public LiveData<Result<Integer>> getRegisterResult(){
        return this.registerResultLiveData;
    }
}
