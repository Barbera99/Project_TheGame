package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.models.Result;
import com.example.project_thegame.service.UserServiceImpl;
import com.example.project_thegame.service.UserService;
import com.example.project_thegame.models.User;
import com.example.project_thegame.viewModels.GameViewModel;
import com.example.project_thegame.viewModels.RegisterViewModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserRepo {
    private static String TAG = "UserRepo";
    private UserService userService;
    private Result<String> registerResult;
    public MutableLiveData<User> mplayer;
    private RegisterViewModel registerViewModel;
    private GameViewModel gameViewModel;

    public UserRepo() {
        this.userService = new UserServiceImpl();
        this.mplayer = new MutableLiveData<>();
    }

    public void getUserById(int user_id){
        userService.getUserById(user_id).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d(TAG, "figa " + response.code());
                        int code = response.code();
                        if (code == 200) {
                            User u = response.body();
                            assert u != null;
                            gameViewModel.player2_username.setValue(u.getUsername());
                            Log.d(TAG, "" + gameViewModel.player2_username.getValue().toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }
                });
    }

    public void registerUser(User user) {
        userService.createUser(user).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "register() -> onResponseSusccess -> " + response.code());
                int code = response.code();
                if (code == 200) {
                    registerViewModel.isRegisteredLiveData.setValue(true);
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                registerResult = Result.error(t);
                Log.d(TAG, "register() -> onFailure -> " + t.getMessage());
            }
        });
    }

    public void setRegisterViewModel(RegisterViewModel registerViewModel){
     this.registerViewModel = registerViewModel;
    }

    public void setGameViewModel(GameViewModel gameViewModel){this.gameViewModel = gameViewModel;
    }
}
