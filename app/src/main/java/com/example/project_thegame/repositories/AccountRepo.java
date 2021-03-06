package com.example.project_thegame.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.helpers.ApiCallBack;
import com.example.project_thegame.models.Account;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.service.AccountService;
import com.example.project_thegame.service.AccountServiceImpl;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.viewModels.LogOutViewModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepo {
    private String TAG = "AccountRepo";

    private AccountService accountService;
    private Result<String> loginResult;
    private MutableLiveData<Result<String>> loginResultLiveData;
    private LogOutViewModel logOutViewModel;

    public AccountRepo(){
        this.accountService = new AccountServiceImpl();
        loginResultLiveData = new MutableLiveData<>();

    }

    // Sends a login query to the backend
    public void login(String authorizationToken){
        this.accountService.createTokenUser(authorizationToken).enqueue(new ApiCallBack<Account>() {

            @Override
            public void onFailure(Call call, Throwable t) {
                loginResult = Result.error(t);
                loginResultLiveData.postValue(loginResult);
                Log.d(TAG, "login() -> onResponseError -> " + t.getMessage());
            }

            @Override
            public void onResponseSuccess(Call<Account> call, Response<Account> response) {
                Log.d(TAG, "Int response");
                Log.d(TAG, "login() -> onResponseSuccess -> " + response.body().toString());
                String token = response.body().getToken();
                int user_id = response.body().getUserId();
                Log.d(TAG, "login() -> onResponseSuccess -> " + token);
                Log.d(TAG, "login() -> onResponseSuccess -> " + user_id);
                loginResult = Result.success(response.body().getToken());
                PreferencesProvider.providePreferences().edit().putInt("user_id", user_id).commit();
                Log.d(TAG,"Login successful, add user_id to SharedPreferences.");
                Log.d(TAG, "login() -> onResponseSuccess / getResult-> " + loginResult.getResult());
                loginResultLiveData.postValue(loginResult);
                Log.d(TAG, "login() -> onResponseSuccess END");
            }

            @Override
            public void onResponseError(Call<Account> call, Throwable t) {
                loginResult = Result.error(t);
                loginResultLiveData.postValue(loginResult);
                Log.d(TAG, "login() -> onResponseError -> " + t.getMessage());
            }
        });
    }

    // Sends a logout query to the backend
    public void logout(String deleteToken){
        this.accountService.deleteTokenUser(deleteToken).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "Deleting TOKEN.....");
                int code = response.code();
                Log.d(TAG, "Codi: " + code);
                if (code == 200) {
                    logOutViewModel.isLoggedOut.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "logOut() -> onFailure -> " + t.getMessage());
            }
        });
    }


    public void setLogOutViewModel(LogOutViewModel logOutViewModel) {
        this.logOutViewModel = logOutViewModel;
    }

    // Gets the answer to login query
    public LiveData<Result<String>> getLoginResult(){
        return this.loginResultLiveData;
    }
}
