package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.project_thegame.databinding.ActivityLoginBinding;
import com.example.project_thegame.databinding.ActivityRegisterBinding;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.models.User;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.utils.UIUtils;
import com.example.project_thegame.viewModels.LoginViewModel;
import com.example.project_thegame.viewModels.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {
    private final String TAG = "RegisterActivity";

    private RegisterViewModel registerViewModel;
    private ActivityRegisterBinding activityRegisterBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerViewModel = new RegisterViewModel();
        registerViewModel.setRegisterActivity(this);
        initDataBinding();

        registerViewModel.isRegisteredLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    Log.d(TAG,"Registre realitzat correctament.");
                    goTo(LoginActivity.class);
                }
                else{
                    //Display Error
                    Log.d(TAG,"Usuari no registrat.");
                }
            }
        });


    }

    private void initDataBinding() {
        activityRegisterBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_register);
        activityRegisterBinding.setRegisterViewModel(registerViewModel);
        activityRegisterBinding.setLifecycleOwner(this);
    }

    public void goTo(Class _class){
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }
}