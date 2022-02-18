package com.example.project_thegame.models;

public class Card {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String name;
    private int strenght;
    private int speed;
    private int agility;
    private int endurance;
    private int intelligencie;
    private boolean locked;
    private Category category;

    /**
     * Diferents categories de cartes.
     */
    enum Category{
        Common,
        Rare,
        Epic,
        Legendary
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
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
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
        return intelligencie;
    }

    public void setIntelligencie(int intelligencie) {
        this.intelligencie = intelligencie;
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
