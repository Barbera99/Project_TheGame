package com.example.project_thegame.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Deck implements Parcelable {
    /**
     * Declaració dels atributs de classe.
     */
    int SIZE = 5;
    private ArrayList<Card> arrayDeck;

    /**
     * Constructor
     *
     */
    public Deck() {
        arrayDeck = new ArrayList<>();
    }

    protected Deck(Parcel in) {
        SIZE = in.readInt();
    }

    public static final Creator<Deck> CREATOR = new Creator<Deck>() {
        @Override
        public Deck createFromParcel(Parcel in) {
            return new Deck(in);
        }

        @Override
        public Deck[] newArray(int size) {
            return new Deck[size];
        }
    };



    public ArrayList<Card> getArrayDeck() {
        return arrayDeck;
    }




    /**
     * Llevarem la carta seleccionada de la baralla.
     */
    public void remove(){
        //TODO
    }
    /**
     * Afegirem la carta seleccionada a la baralla.
     */
    public void add(Card c){
        for(int i = 0; i < SIZE;i++){
            if(SIZE>this.arrayDeck.size()){
                arrayDeck.add(c);
            }
        }
        //TODO
    }
    /**
     * Comprovem si la carta a afegir ja forma part de la baralla.
     */
    public void check(){
        //TODO
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public int getSIZE() {
        return SIZE;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(SIZE);
    }
}
