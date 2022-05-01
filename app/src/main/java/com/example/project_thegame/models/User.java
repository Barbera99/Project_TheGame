package com.example.project_thegame.models;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class User implements Parcelable {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String username;
    private Date created_at;
    private String email;
    private String name;
    private String surname;
    private Date birthdate;
    private String genere;
    private int phone;
    private String photo;
    private int rank_id;
    private String status;
    private Deck playerDeck;
    private ArrayList<Card> listOfCardsOwned;

    /**
     * CONSTRUCTOR
     */
    public User(int id, String username, ArrayList<Card> lCard) {
        this.id = id;
        this.username = username;
        this.playerDeck = new Deck();
        this.listOfCardsOwned = lCard;
    }





    /**
     * Declaració dels getters i setters.
     */
    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }


    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Card> getListOfCardsOwned() {
        return listOfCardsOwned;
    }

    public void setListOfCardsOwned(ArrayList<Card> listOfCardsOwned) {
        this.listOfCardsOwned = listOfCardsOwned;
    }


    //altres
    // public static Player getPlayerById(int id) {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.username);
        dest.writeParcelable(this.playerDeck, flags);
        dest.writeList(this.listOfCardsOwned);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.username = source.readString();
        this.playerDeck = source.readParcelable(Deck.class.getClassLoader());
        this.listOfCardsOwned = new ArrayList<Card>();
        source.readList(this.listOfCardsOwned, Card.class.getClassLoader());
    }

    protected User(Parcel in) {
        this.id = in.readInt();
        this.username = in.readString();
        this.playerDeck = in.readParcelable(Deck.class.getClassLoader());
        this.listOfCardsOwned = new ArrayList<Card>();
        in.readList(this.listOfCardsOwned, Card.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


}
