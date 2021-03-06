package com.example.project_thegame.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class User {
    /**
     * DeclaraciĆ³ dels atributs de classe.
     */
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;
    @SerializedName("surname")
    private String surname;
    @SerializedName("password")
    private String password;

    private Date created_at;
    private Date birthdate;
    private String genere;
    private int phone;
    private String photo;
    private int rank_id;
    private String status;
    private Deck playerDeck;
    private ArrayList<Card> listOfCardsOwned;

    public User(int id, String username, Date created_at, String email, String name, String surname, Date birthdate, String genere, int phone, String photo, int rank_id, String status, Deck playerDeck, ArrayList<Card> listOfCardsOwned) {
        this.id = id;
        this.username = username;
        this.created_at = created_at;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.genere = genere;
        this.phone = phone;
        this.photo = photo;
        this.rank_id = rank_id;
        this.status = status;
        this.playerDeck = playerDeck;
        this.listOfCardsOwned = listOfCardsOwned;
    }

    public User(String username, String email, String name, String surname, String password) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }
    public User() {
    }

    /**
     * DeclaraciĆ³ dels getters i setters.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRank_id() {
        return rank_id;
    }

    public void setRank_id(int rank_id) {
        this.rank_id = rank_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }

    public ArrayList<Card> getListOfCardsOwned() {
        return listOfCardsOwned;
    }

    public void setListOfCardsOwned(ArrayList<Card> listOfCardsOwned) {
        this.listOfCardsOwned = listOfCardsOwned;
    }



}
