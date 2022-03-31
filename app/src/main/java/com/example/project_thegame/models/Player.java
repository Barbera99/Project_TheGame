package com.example.project_thegame.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Player implements Parcelable {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String name;
    private int games_played;
    private int wins;
    private int defeats;
    private Deck playerDeck;
    private ArrayList<Card> listOfCardsOwned;

    /**
     * CONSTRUCTOR
     */
    public Player(int id, String name, int games_played, int wins, int defeats, ArrayList<Card> lCard) {
        this.id = id;
        this.name = name;
        this.games_played = games_played;
        this.wins = wins;
        this.defeats = defeats;
        this.playerDeck = new Deck();
        this.listOfCardsOwned = lCard;
    }





    /**
     * Declaració dels getters i setters.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
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
        dest.writeString(this.name);
        dest.writeInt(this.games_played);
        dest.writeInt(this.wins);
        dest.writeInt(this.defeats);
        dest.writeParcelable(this.playerDeck, flags);
        dest.writeList(this.listOfCardsOwned);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
        this.games_played = source.readInt();
        this.wins = source.readInt();
        this.defeats = source.readInt();
        this.playerDeck = source.readParcelable(Deck.class.getClassLoader());
        this.listOfCardsOwned = new ArrayList<Card>();
        source.readList(this.listOfCardsOwned, Card.class.getClassLoader());
    }

    protected Player(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.games_played = in.readInt();
        this.wins = in.readInt();
        this.defeats = in.readInt();
        this.playerDeck = in.readParcelable(Deck.class.getClassLoader());
        this.listOfCardsOwned = new ArrayList<Card>();
        in.readList(this.listOfCardsOwned, Card.class.getClassLoader());
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };


}
