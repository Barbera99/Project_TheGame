package com.example.project_thegame.models;

import android.media.Image;

public class Map {
    private String name;
    private int id;
    private int attribute;
    private int extra_attribute;
    private Type type;
    private Image image;

    /*
     * LListat dels diferents tipus de proves que hi han.
     */
    enum Type{
        Marathon,
        Sprint,
        Puzzle,
        Strenght,
        ObstacleRace,
        Climbing
    }

    /**
     *
     * @param name
     * @param id
     * @param attribute
     * @param extra_attribute
     * @param type
     * @param image
     */
    public Map(String name, int id, int attribute, int extra_attribute, Type type, Image image) {
        this.name = name;
        this.id = id;
        this.attribute = attribute;
        this.extra_attribute = extra_attribute;
        this.type = type;
        this.image = image;
    }

    /*
     * Declaració dels getters i setters.
     */
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
