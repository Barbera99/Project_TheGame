package com.example.project_thegame.models;

public class Map {
    /* Attributes */
    private String name;
    private int id;
    private int attribute;
    private int extra_attribute;
    private Type type;

    /* Diferent map types */
    enum Type{
        Marathon,
        Sprint,
        Puzzle,
        Strenght,
        ObstacleRace,
        Climbing
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getExtra_attribute() {
        return extra_attribute;
    }

    public void setExtra_attribute(int extra_attribute) {
        this.extra_attribute = extra_attribute;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
