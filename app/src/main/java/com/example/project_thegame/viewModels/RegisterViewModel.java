package com.example.project_thegame.viewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project_thegame.LoginActivity;
import com.example.project_thegame.MainActivity;
import com.example.project_thegame.RegisterActivity;
import com.example.project_thegame.models.Result;
import com.example.project_thegame.models.User;
import com.example.project_thegame.repositories.UserRepo;
import com.example.project_thegame.utils.AccountUtils;

public class RegisterViewModel extends ViewModel {
    private String TAG = "RegisterViewModel";

    private MutableLiveData<String> nameLiveData;
    private MutableLiveData<String> surnameLiveData;
    private MutableLiveData<String> emailLiveData;
    private MutableLiveData<String> usernameLiveData;
    private MutableLiveData<String> passwordLiveData;
    public MutableLiveData<Boolean> isRegisteredLiveData;
    private UserRepo userRepo;
    private RegisterActivity registerActivity;

    public RegisterViewModel(){
        this.nameLiveData = new MutableLiveData<String>();
        this.surnameLiveData = new MutableLiveData<String>();
        this.emailLiveData = new MutableLiveData<String>();
        this.usernameLiveData = new MutableLiveData<String>();
        this.passwordLiveData = new MutableLiveData<String>();
        this.isRegisteredLiveData = new MutableLiveData<Boolean>();
        this.userRepo = new UserRepo();
    }
    public void register() {
        String name = nameLiveData.getValue();
        String surname = surnameLiveData.getValue();
        String email = emailLiveData.getValue();
        String username = usernameLiveData.getValue();
        String password = passwordLiveData.getValue();

        if(isFormValid(email, password, name, surname, username)){
            User user = new User(username, email, name, surname, password);
            this.userRepo.registerUser(user);
        }
    }
    private Boolean isFormValid(String email, String password, String name, String surname, String username){
        boolean isValid = true;

        String validEmail= AccountUtils.isEmailValid(email);
        if ( validEmail != null){
            isValid = false;
        };
        if (name == null || surname == null || username == null) {
            isValid = false;
        }
        /*
        String validPassword= AccountUtils.isPasswordValid(password);
        if ( validPassword != null){
            isValid = false;
            errorPasswordLiveData.postValue(validPassword);
        }; */

        return isValid;
    }

    /*
                        SETTERS I GETTERS
     */
    public MutableLiveData<String> getNameLiveData() {
        return nameLiveData;
    }

    public void setNameLiveData(MutableLiveData<String> nameLiveData) {
        this.nameLiveData = nameLiveData;
    }

    public MutableLiveData<String> getSurnameLiveData() {
        return surnameLiveData;
    }

    public void setSurnameLiveData(MutableLiveData<String> surnameLiveData) {
        this.surnameLiveData = surnameLiveData;
    }

    public MutableLiveData<String> getEmailLiveData() {
        return emailLiveData;
    }

    public void setEmailLiveData(MutableLiveData<String> emailLiveData) {
        this.emailLiveData = emailLiveData;
    }

    public MutableLiveData<String> getUsernameLiveData() {
        return usernameLiveData;
    }

    public void setUsernameLiveData(MutableLiveData<String> usernameLiveData) {
        this.usernameLiveData = usernameLiveData;
    }

    public MutableLiveData<String> getPasswordLiveData() {
        return passwordLiveData;
    }

    public void setPsswdLiveData(MutableLiveData<String> passwordLiveData) {
        this.passwordLiveData = passwordLiveData;
    }

    public MutableLiveData<Boolean> getIsRegisteredLiveData() {
        return isRegisteredLiveData;
    }

    public void setIsRegisteredLiveData(MutableLiveData<Boolean> isRegisteredLiveData) {
        this.isRegisteredLiveData = isRegisteredLiveData;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void setRegisterActivity(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }


}
