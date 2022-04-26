package com.example.project_thegame.viewModels;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.User;

import java.util.ArrayList;
import java.util.Random;

public class GameViewModel {
    private Game game;
    private int roundNumber;
    private int playerScore;
    Card iACard;
    Card cardSelected;
    Deck deckForIA = new Deck();
    int positionCard;
    int iAScore = 0;
    String attributeActualRound;

    Deck easyDeck;
    Deck mediumDeck;
    Deck hardDeck;
    public static Card easy1 = new Card(1, "Easy1", 30, 30, 10, 20, 10, false, 3);
    public static Card easy2 = new Card(2, "Easy2", 20, 20, 30, 10, 20, false, 1);
    public static Card easy3 = new Card(3, "Easy3", 10, 10, 20, 30, 30, false, 3);
    public static Card medium1 = new Card(4, "Medium1", 50, 40, 40, 60, 50, false, 3);
    public static Card medium2 = new Card(5, "Medium2", 40, 60, 50, 50, 60, false, 3);
    public static Card medium3 = new Card(6, "Medium3", 60, 50, 60, 40, 40, false, 2);
    public static Card hard1 = new Card(7, "Hard1", 80, 90, 60, 70, 70, false, 1);
    public static Card hard2 = new Card(8, "Hard2", 70, 60, 80, 70, 70, false, 2);
    public static Card hard3 = new Card(9, "Hard3", 80, 70, 60, 90, 80, false, 2);

    public GameViewModel(Game game) {
        this.game = game;
        this.easyDeck = new Deck();
        this.mediumDeck = new Deck();
        this.hardDeck = new Deck();
        this.roundNumber = 1;
        this.iACard = new Card(-1, "test", -1, -1, -1, -1, -1, false, 1);
    }

    public void setPlayer(User user) {
        this.game.setPlayer1(user);
    }

    public void setIADifficult(String diffSelected){
        Card[] newC = new Card[5];
        if(diffSelected.equals("Easy")){
            newC[0] = easy1;
            newC[1] = easy2;
            newC[2] = easy3;
            newC[3] = easy2;
            newC[4] = easy1;
        }else if(diffSelected.equals("Medium")){
            newC[0] = medium1;
            newC[1] = medium2;
            newC[2] = medium3;
            newC[3] = medium1;
            newC[4] = medium3;
        }else if(diffSelected.equals("Hard")){
            newC[0] = hard1;
            newC[1] = hard2;
            newC[2] = hard3;
            newC[3] = hard2;
            newC[4] = hard3;
        }
        deckForIA.setArrayDeck(newC);
        game.getPlayer2().setPlayerDeck(deckForIA);
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public String getAttributeActualRound() {
        return attributeActualRound;
    }

    public Card getCardSelected(int i) {
        return game.getPlayer1().getPlayerDeck().getArrayDeck().get(i);
    }

    public ArrayList<String> arrayListText(Card c, int i){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(c.getName());
        arrayList.add("Fuerza:"+c.getStrenght());
        arrayList.add("Velocidad:"+c.getSpeed());
        arrayList.add("Agilidad:"+c.getAgility());
        arrayList.add("Aguante:"+c.getEndurance());
        arrayList.add("Inteligencia:"+c.getIntelligencie());
        arrayList.add("Categoria:"+c.getCategory());
        positionCard = i;
        cardSelected = c;
        return arrayList;
    }

    public Bitmap getConfPaint(Bitmap bm,String s, int size){
        Bitmap.Config config = bm.getConfig();
        int width = bm.getWidth();
        int height = bm.getHeight();
        Bitmap newImage = Bitmap.createBitmap(width, height, config);
        Canvas c = new Canvas(newImage);
        c.drawBitmap(bm, 0, 0, null);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(size);
        c.drawText(s, width/2, (height/2)-((paint.descent()+paint.ascent())/2), paint);
        return newImage;
    }
    /**
     * Comprovem la puntuació.
     */
    public void check_score(){
        //TODO
    }
    /**
     * Passem a la següent ronda.
     */
    public void next_round(){
        //TODO
    }
    /**
     * Començem la partida.
     */
    public void start_game(){
        //TODO
    }
    /**
     * Comprovem si algun dels jugadors a assolit el nombre de victories mínimes per a guanyar la partia.
     */
    public boolean check_winner(){
        if(game.getScore_player1() >= 3 || game.getScore_player2() >= 3) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Escollirem un dels diferents mapes per cada ronda.
     */
    public void choose_map(){
        //TODO
    }
    public void check_round_score(){

        /*round.getPlayer1();
        if(player1card.getSpeed() > player2card.getSpeed()) {
            System.out.println("Ha guanyat el jugador 1");
            player1score++;
        } else if(player1card.getSpeed() < player2card.getSpeed()) {
            System.out.println("Ha guanyat el jugador 2");
            player2score++;
        }*/
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getiAScore() {
        return iAScore;
    }

    protected ArrayList<String> checkWinner(int attributePlayer, int attributeIA){
        ArrayList<String> result = new ArrayList<>();
        if(attributeIA > attributePlayer){
            iAScore++;
            result.add("IA");
            result.add(String.valueOf(attributeIA));
        } else if(attributeIA < attributePlayer) {
            playerScore++;
            result.add("Player");
            result.add(String.valueOf(attributePlayer));
        } else {
            result.add("empate");
            result.add(String.valueOf(attributeIA));
        }
        return result;
    }

    public ArrayList<String> nextRound(){
        randomAttribute();
        roundNumber++;
        IAIntell();
        ArrayList<String> result = null;
        if(attributeActualRound == "Fuerza"){
            result = checkWinner(cardSelected.getStrenght(),iACard.getStrenght());
            result.add("Fuerza");
        } else if(attributeActualRound == "Velocidad"){
            result = checkWinner(cardSelected.getSpeed(),iACard.getSpeed());
            result.add("Velocidad");
        } else if(attributeActualRound == "Agilidad"){
            result = checkWinner(cardSelected.getAgility(),iACard.getAgility());
            result.add("Agilidad");
        } else if(attributeActualRound == "Aguante"){
            result = checkWinner(cardSelected.getEndurance(),iACard.getEndurance());
            result.add("Aguante");
        } else if(attributeActualRound == "Inteligencia"){
            result = checkWinner(cardSelected.getIntelligencie(),iACard.getIntelligencie());
            result.add("Inteligencia");
        }
        return result;
    }

    protected void IAIntell(){
        if(attributeActualRound.equals("Fuerza")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getStrenght() > iACard.getStrenght()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Velocidad")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getSpeed() > iACard.getSpeed()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Agilidad")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getAgility() > iACard.getAgility()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Aguante")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getEndurance() > iACard.getEndurance()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Inteligencia")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getIntelligencie() > iACard.getIntelligencie()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        }
    }
    public void randomAttribute(){
        int random = new Random().nextInt((5-1)+1) + 1;
        if(random == 1){
            attributeActualRound = "Fuerza";
        } else if(random == 2){
            attributeActualRound = "Velocidad";
        } else if(random == 3){
            attributeActualRound = "Agilidad";
        } else if(random == 4){
            attributeActualRound = "Aguante";
        } else if(random == 5){
            attributeActualRound = "Inteligencia";
        }

    }
}
