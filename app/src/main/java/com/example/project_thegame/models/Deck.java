package com.example.project_thegame.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Deck implements Parcelable {
    /**
     * Declaració dels atributs de classe.
     */
    int SIZE = 5;
    private ArrayList<Card> arrayDeck = new ArrayList<>();

    /**
     * Constructor
     */
    public Deck(ArrayList<Card> Deck) {
        this.arrayDeck = Deck;
    }

    /**
     * Llevarem la carta seleccionada de la baralla.
     */
    public void remove(Card c){
        this.arrayDeck.remove(c);
    }

    /**
     * Afegirem la carta seleccionada a la baralla.
     */
    public void add(Card c, int i){
        if(SIZE>this.arrayDeck.size()){
            arrayDeck.add(c);
        } else {
            arrayDeck.set(i-1,c);
        }
        //TODO
    }
    /**
     * Comprovem si la carta a afegir ja forma part de la baralla.
     */
    public boolean checkCardinDeck(Card c){
        for (int i = 0; i < SIZE; i++){
            if(this.arrayDeck.contains(c)){
                return false;
            }
        }
        return true;
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public void setSIZE(int SIZE){ this.SIZE = SIZE; }
    public int getSIZE() {
        return SIZE;
    }
    public ArrayList<Card> getArrayDeck() {
        return arrayDeck;
    }
    public void setArrayDeck(ArrayList<Card> arrayDeck) {
        this.arrayDeck = arrayDeck;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.SIZE);
        dest.writeTypedList(this.arrayDeck);
    }

    public void readFromParcel(Parcel source) {
        this.SIZE = source.readInt();
        this.arrayDeck = source.createTypedArrayList(Card.CREATOR);
    }

    protected Deck(Parcel in) {
        this.SIZE = in.readInt();
        this.arrayDeck = in.createTypedArrayList(Card.CREATOR);
    }

    public static final Creator<Deck> CREATOR = new Creator<Deck>() {
        @Override
        public Deck createFromParcel(Parcel source) {
            return new Deck(source);
        }

        @Override
        public Deck[] newArray(int size) {
            return new Deck[size];
        }
    };
}
