package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.project_thegame.databinding.ActivityLoginBinding;
import com.example.project_thegame.utils.UIUtils;
import com.example.project_thegame.viewModels.LoginViewModel;

public class RegisterActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding activityRegisterBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginViewModel = new LoginViewModel();
        initDataBinding();
    }

    private void initDataBinding() {
        activityRegisterBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_register);
        activityRegisterBinding.setLoginViewModel(loginViewModel);
        activityRegisterBinding.setLifecycleOwner(this);
    }

    
    private void showRegisterError(String errorMessage){
        DialogInterface.OnClickListener positiveAction = (dialogInterface, i) -> dialogInterface.cancel();
        UIUtils.showAlert(this,"Error", errorMessage, "Ok",positiveAction ,null,null, false);
    }

    public static void goTo(Class _class){
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }
}