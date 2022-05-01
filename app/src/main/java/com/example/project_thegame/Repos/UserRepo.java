package com.example.project_thegame.Repos;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.Implementation.UserServiceImpl;
import com.example.project_thegame.Interfaces.UserService;
import com.example.project_thegame.Network.RetrofitClientInstance;
import com.example.project_thegame.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserRepo {
    private static String TAG = "UserRepo";
    private UserService userService;
    public MutableLiveData<User> mplayer;
    public UserRepo() {
        this.userService = new UserServiceImpl();
        this.mplayer = new MutableLiveData<>();
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
}
