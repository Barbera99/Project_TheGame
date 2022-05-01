package com.example.project_thegame.models;

public class Achievements {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String name;
    private String description;
    private Type type;
    private Difficulty difficulty;

    /**
     * LListat dels diferents tipus de assoliments que hi han.
     *
     */
    enum Type{
        Weekly,
        Monthly,
        Diary,
        Event
    }
    /**
     * LListat de les diferents tipus de dificultats que hi han.
     *
     */
    enum Difficulty{
        Hard,
        Medium,
        Easy
    }

    /**
     * Declaració dels getters i setters.
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
