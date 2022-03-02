package com.example.project_thegame.models;

public class Card {
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
}
