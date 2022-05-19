package com.example.project_thegame.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project_thegame.utils.AccountUtils;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.views.MainActivity;
import com.example.project_thegame.repositories.AccountRepo;

public class LogOutViewModel extends ViewModel {
    private String TAG = "LogOutViewModel";

    public MutableLiveData<Boolean> isLoggedOut;
    private AccountRepo accountRepo;
    private MainActivity mainActivity;

    public LogOutViewModel(){
        this.isLoggedOut = new MutableLiveData<Boolean>();
        this.accountRepo = new AccountRepo();
        this.accountRepo.setLogOutViewModel(this);
    }

    public void logOut (String deleteToken){
        this.accountRepo.logout(deleteToken);
    }

    public MutableLiveData<Boolean> getIsLoggedOut() {
        return isLoggedOut;
    }

    public void setIsLoggedOut(MutableLiveData<Boolean> isLoggedOut) {
        this.isLoggedOut = isLoggedOut;
    }

    public void setMainActivity(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }
}
