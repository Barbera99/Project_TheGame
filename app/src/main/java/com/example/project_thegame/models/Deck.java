package com.example.project_thegame.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Deck implements Parcelable {
    /**
     * Declaració dels atributs de classe.
     */
    int id;
    int SIZE;
    private ArrayList<Card> arrayDeck;

    /**
     * Constructor
     *
     */
    public Deck() {
        arrayDeck = new ArrayList<>();
        SIZE = 5;
    }


    public ArrayList<Card> getArrayDeck() {
        return arrayDeck;
    }


    public void setArrayDeck(Card[] vectCard){
        arrayDeck = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            arrayDeck.add(vectCard[i]);
        }
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
