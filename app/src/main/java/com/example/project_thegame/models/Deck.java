package com.example.project_thegame.models;

public class Deck {
    /**
     * Declaració dels atributs de classe.
     */
    final int SIZE = 5;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    /**
     * Constructor
     *
     */
    public Deck(Card card1, Card card2, Card card3, Card card4, Card card5) {
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
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
    public void add(){
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

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    public Card getCard4() {
        return card4;
    }

    public void setCard4(Card card4) {
        this.card4 = card4;
    }

    public Card getCard5() {
        return card5;
    }

    public void setCard5(Card card5) {
        this.card5 = card5;
    }
}
