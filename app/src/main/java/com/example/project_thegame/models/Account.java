package com.example.project_thegame.models;

import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("token")
    private String token;
    @SerializedName("user_id")
    private int user_id;


    public Account(){
        this.token = "";
    }


    public String getToken() {
        return token;
    }

    public int getUserId() {
        return user_id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId() {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "token='" + token + '\'' +
                '}';
    }
}
