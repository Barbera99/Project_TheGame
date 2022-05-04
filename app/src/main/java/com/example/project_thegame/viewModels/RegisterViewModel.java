package com.example.project_thegame.viewModels;

import androidx.lifecycle.MutableLiveData;

import com.example.project_thegame.repositories.AccountRepo;

public class RegisterViewModel {
    private String TAG = "LoginViewModel";

    private MutableLiveData<String> name;
    private MutableLiveData<String> surname;
    private MutableLiveData<String> email;
    private MutableLiveData<String> username;
    private MutableLiveData<String> psswd;
    public MutableLiveData<Boolean> isRegistered;
    private AccountRepo accountRepo;

    public RegisterViewModel(){
        this.name = new MutableLiveData<String>();
        this.surname = new MutableLiveData<String>();
        this.email = new MutableLiveData<String>();
        this.username = new MutableLiveData<String>();
        this.isRegistered = new MutableLiveData<Boolean>();
        this.accountRepo = new AccountRepo();
    }
}
