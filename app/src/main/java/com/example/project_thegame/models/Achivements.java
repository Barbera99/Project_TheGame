package com.example.project_thegame.models;

public class Achivements {
    /**
     * Declaració dels atributs de classe.
     */
    private int id;
    private String name;
    private int requirements;
    private boolean achieved = false;

    /**
     * Comprovem si el jugador a assolit un logro.
     */
    public void check_achievements(){
        //TODO
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

    public int getRequirements() {
        return requirements;
    }

    public void setRequirements(int requirements) {
        this.requirements = requirements;
    }


}
