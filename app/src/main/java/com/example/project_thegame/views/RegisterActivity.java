package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.project_thegame.R;
import com.example.project_thegame.databinding.ActivityRegisterBinding;
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
                    showToast("Usuari registrat correctament");
                    goTo(LoginActivity.class);
                }
                else{
                    //Display Error
                    Log.d(TAG,"Usuari no registrat.");
                    showToast("Usuari no registrat correctament");
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

    protected void showToast(String msg){
        Toast myToast = Toast.makeText(this,msg,Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.show();
    }
}