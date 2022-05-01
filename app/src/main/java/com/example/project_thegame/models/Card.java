package com.example.project_thegame.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Card implements Parcelable {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String name;
    private int strength;
    private int speed;
    private int agility;
    private int endurance;
    private int intelligence;
    private boolean locked;
    private Category category;

    /**
     * Diferents categories de cartes.
     */
    enum Category{
        Common, //0
        Rare, //1
        Epic, //2
        Legendary //3
    }

    /**
     * Constructor
     *
     */
    public Card(int id, String name, int strength, int speed, int agility, int endurance, int intelligence, boolean locked, int category) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.speed = speed;
        this.agility = agility;
        this.endurance = endurance;
        this.intelligence = intelligence;
        this.locked = locked;
        this.category = Category.values()[category];
    }

    /**
     * Declaració getters i setters dels atributs de la classe.
     *
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrenght() {
        return strength;
    }

    public void setStrenght(int strenght) {
        this.strength = strenght;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getIntelligencie() {
        return intelligence;
    }

    public void setIntelligencie(int intelligencie) {
        this.intelligence = intelligencie;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.strength);
        dest.writeInt(this.speed);
        dest.writeInt(this.agility);
        dest.writeInt(this.endurance);
        dest.writeInt(this.intelligence);
        dest.writeByte(this.locked ? (byte) 1 : (byte) 0);
        dest.writeInt(this.category == null ? -1 : this.category.ordinal());
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.name = source.readString();
        this.strength = source.readInt();
        this.speed = source.readInt();
        this.agility = source.readInt();
        this.endurance = source.readInt();
        this.intelligence = source.readInt();
        this.locked = source.readByte() != 0;
        int tmpCategory = source.readInt();
        this.category = tmpCategory == -1 ? null : Category.values()[tmpCategory];
    }

    protected Card(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.strength = in.readInt();
        this.speed = in.readInt();
        this.agility = in.readInt();
        this.endurance = in.readInt();
        this.intelligence = in.readInt();
        this.locked = in.readByte() != 0;
        int tmpCategory = in.readInt();
        this.category = tmpCategory == -1 ? null : Category.values()[tmpCategory];
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel source) {
            return new Card(source);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
}
