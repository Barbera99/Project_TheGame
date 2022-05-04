package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.project_thegame.databinding.ActivityLoginBinding;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.utils.UIUtils;
import com.example.project_thegame.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding activityLoginBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = new LoginViewModel();
        initDataBinding();

        setup();
        data();

        loginViewModel.isUserLogged().observe(this, new Observer<Result<String>>() {
            @Override
            public void onChanged(Result<String> tokenResult) {
                loginViewModel.isLogged.postValue(false);
                if (tokenResult.getResult() != null){
                    Log.d(TAG,"Login successful, token obtained.");
                    PreferencesProvider.providePreferences().edit().putString("token",
                            tokenResult.getResult()).commit();
                    Log.d(TAG,"Login successful, add token to SharedPreferences.");
                    goTo(MainActivity.class);
                }
                else{
                    //Display Error
                    Log.d(TAG,"User not logged, token not obtained.");
                    showLoginError(tokenResult.getError().getMessage());
                }
            }
        });
        final TextView link_signup = (TextView) findViewById(R.id.link_signup);

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }


    private void showLoginError(String errorMessage){
        DialogInterface.OnClickListener positiveAction = (dialogInterface, i) -> dialogInterface.cancel();
        UIUtils.showAlert(this,"Error", errorMessage, "Ok",positiveAction ,null,null, false);
    }

    private void initDataBinding() {
        activityLoginBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityLoginBinding.setLoginViewModel(loginViewModel);
        activityLoginBinding.setLifecycleOwner(this);
    }

    public void goTo(Class _class){
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }


    private void setup(){
        PreferencesProvider.init(this);
    }

    private void data(){
        String token = PreferencesProvider.providePreferences().getString("token", "");
        Log.d(TAG, "token: " + token);
        if (token.equals("")) {
            // If device has no token -> go to LoginActivity()
            //startActivity(new Intent(this, LoginActivity.class));
            //showLogin();
        } else {
            // If a userToken is stored on sharedPreferences go to MainActivity().
            startActivity(new Intent(this, MainActivity.class));
        }
        // Close the activity, the user don't need to enter again with back functionality
        //finish();
    }
}
