package com.example.project_thegame.models;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private int id;
    private Date created_at;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private Date birthdate;
    private char genere;
    private String phone;
    private Image photo;
    private int id_rank;

    /**
     *
     * @param id
     * @param created_at
     * @param username
     * @param password
     * @param email
     * @param name
     * @param surname
     * @param birthdate
     * @param genere
     * @param phone
     * @param photo
     * @param id_rank
     */
    public User(int id, Date created_at, String username, String password, String email, String name, String surname, Date birthdate, char genere, String phone, Image photo, int id_rank) {
        this.id = id;
        this.created_at = created_at;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.genere = genere;
        this.phone = phone;
        this.photo = photo;
        this.id_rank = id_rank;
    }

    /**
     *
     * @param created_at
     * @param username
     * @param birthdate
     * @param photo
     * @param id_rank
     */
    public User(Date created_at, String username, Date birthdate, Image photo, int id_rank) {
        this.created_at = created_at;
        this.username = username;
        this.birthdate = birthdate;
        this.photo = photo;
        this.id_rank = id_rank;
    }

    public User() {
    }

    /* Setters and getters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public char getGenere() {
        return genere;
    }

    public void setGenere(char genere) {
        this.genere = genere;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public int getId_rank() {
        return id_rank;
    }

    public void setId_rank(int id_rank) {
        this.id_rank = id_rank;
    }


}
