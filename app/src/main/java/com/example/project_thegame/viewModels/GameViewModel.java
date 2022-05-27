package com.example.project_thegame.viewModels;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project_thegame.R;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.views.GameActivity;
import com.example.project_thegame.repositories.GameRepo;
import com.example.project_thegame.repositories.DeckRepo;
import com.example.project_thegame.repositories.UserRepo;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.User;
import com.example.project_thegame.views.MainActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameViewModel extends ViewModel {
    private static String TAG = "GameViewModel";


    public MutableLiveData<Boolean> isGameStarted;
    public MutableLiveData<Boolean> isGameEnded;
    public MutableLiveData<String> player1_username;
    public MutableLiveData<String> player2_username;
    public MutableLiveData<String> player1_scoreLiveData;
    public MutableLiveData<String> player2_scoreLiveData;
    public MutableLiveData<String> round_number;
    int player1_score;
    int player2_score;
    int player1_id;
    private  UserRepo userRepo;
    private  DeckRepo deckRepo;
    private  GameRepo gameRepo;

    private GameActivity gameActivity;
    private MainActivity mainActivity;
    public void setGameActivity(GameActivity gameActivity){
        this.gameActivity = gameActivity;
    }
    public void setMainActivity(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    int roundNumber;
    int playerScore;
    Card iACard;
    Card cardSelected;
    Deck deckForIA = new Deck();
    int positionCard;
    String attributeActualRound;
    Game game;
    Deck easyDeck;
    Deck mediumDeck;
    Deck hardDeck;

    /**
     * Cartes baralla IA
      */
    public static Card easy1 = new Card(1, "Easy1", 30, 30, 10, 20, 10, false, 3);
    public static Card easy2 = new Card(2, "Easy2", 20, 20, 30, 10, 20, false, 1);
    public static Card easy3 = new Card(3, "Easy3", 10, 10, 20, 30, 30, false, 3);
    public static Card medium1 = new Card(4, "Medium1", 50, 40, 40, 60, 50, false, 3);
    public static Card medium2 = new Card(5, "Medium2", 40, 60, 50, 50, 60, false, 3);
    public static Card medium3 = new Card(6, "Medium3", 60, 50, 60, 40, 40, false, 2);
    public static Card hard1 = new Card(7, "Hard1", 80, 90, 60, 70, 70, false, 1);
    public static Card hard2 = new Card(8, "Hard2", 70, 60, 80, 70, 70, false, 2);
    public static Card hard3 = new Card(9, "Hard3", 80, 70, 60, 90, 80, false, 2);
    public static Card c = new Card(-1, "test", -1, -1, -1, -1, -1, false, 1);

    /**
     * Cartes baralla usuari
     */
    public static Card card_1 = new Card(1, "Ninja", 35, 75, 90, 20, 65, false, 3);
    public static Card card_2 = new Card(2, "Dummy", 30, 30, 10, 95, 0, false, 1);
    public static Card card_3 = new Card(3, "Sonic", 10, 99, 85, 95, 20, false, 3);
    public static Card card_4 = new Card(4, "Linda", 75, 40, 40, 40, 30, false, 3);
    public static Card card_5 = new Card(5, "Paco", 40, 60, 50, 10, 10, false, 3);
    ArrayList<Card> user_deck = new ArrayList<>();

    public GameViewModel(){
        this.gameRepo = new GameRepo();
        this.deckRepo = new DeckRepo();
        this.userRepo = new UserRepo();
        this.isGameEnded = new MutableLiveData<>();
        this.isGameStarted = new MutableLiveData<>();
        this.player1_scoreLiveData = new MutableLiveData<>();
        this.player1_username = new MutableLiveData<>();
        this.player2_scoreLiveData = new MutableLiveData<>();
        this.player2_username = new MutableLiveData<>();
        this.round_number = new MutableLiveData<>();
        this.gameRepo.setGameViewModel(this);
        this.userRepo.setGameViewModel(this);
    }

    public void play(){
        user_deck.add(card_1);
        user_deck.add(card_2);
        user_deck.add(card_3);
        user_deck.add(card_4);
        user_deck.add(card_5);
        this.player1_username.setValue("IA Bot");
        this.userRepo.getUserById(PreferencesProvider.providePreferences().getInt("user_id", 0));
        this.player1_scoreLiveData.setValue("0");
        this.player1_scoreLiveData.setValue("0");
    }

    public void setIADifficult(String diffSelected){
        ArrayList<Card> newC = new ArrayList<>();
        if(diffSelected.equals("Easy")){
            newC.add(easy1);
            newC.add(easy2);
            newC.add(easy3);
            newC.add(easy3);
            newC.add(easy2);
        }else if(diffSelected.equals("Medium")){
            newC.add(medium1);
            newC.add(medium2);
            newC.add(medium3);
            newC.add(medium1);
            newC.add(medium2);
        }else if(diffSelected.equals("Hard")){
            newC.add(hard1);
            newC.add(hard1);
            newC.add(hard3);
            newC.add(hard1);
            newC.add(hard2);
        }
        deckForIA.setArrayDeck(newC);
    }
    public ArrayList<Card> getUserDeck() {
        ArrayList<Card> pDeck = new ArrayList<Card>();
        this.deckRepo.getDeck(1);
        return pDeck;
    }

    public int getPositionCard(){return positionCard;}
    public void setPositionCard(int pC){this.positionCard = pC;}
    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int rN){this.roundNumber = rN;}
    public String getAttributeActualRound() {
        return attributeActualRound;
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

    public Bitmap getConfPaint(Bitmap bm, int size){
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
        c.drawText(this.attributeActualRound, width/2, (height/2)-((paint.descent()+paint.ascent())/2), paint);
        return newImage;
    }

    /**
     * Guardem la partida.
     */
    public void save_game(int id_player1){
        this.player1_id = id_player1;
        Game game = new Game(1, id_player1, player1_score, player2_score);
        this.gameRepo.createGame(id_player1, game);
    }

    /**
     * Finalitzem la partida i guardem la puntuació dels jugadors.
     */
    public void endGame(){

    }

    /**
     * Comprovem qui guanya la ronda.
     */
    protected ArrayList<String> checkWinner(int attributePlayer, int attributeIA){
        ArrayList<String> result = new ArrayList<>();
        if(attributeIA > attributePlayer){
            player2_score++;
            result.add("IA");
            result.add(String.valueOf(attributeIA));
        } else {
            playerScore++;
            result.add("Player");
            result.add(String.valueOf(attributePlayer));
        }
        return result;
    }

    /**
     * Pasem a la següent ronda, comprovant el guanyador d'aquesta.
     * @return result String
     */
    public ArrayList<String> nextRound(){
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
        randomAttribute();
        cardSelected = c;
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

    public void onclickedAt(int card_id){
        Log.d(TAG, "" + card_id);
        cardSelected = user_deck.get(card_id);
        gameActivity.nextRound();
        round_number.setValue(Integer.toString(roundNumber));
    }


/**
 * TIMERS
 *
    //CONTROLADOR DEL TEMPS MAXIM PER RONDA
    //DISPLAY DEL TEMPS MAXIM PER RONDA
    textV = (TextView) findViewById(R.id.textTimer);
    mCountD = new CountDownTimer(60000, 1000) {

        public void onTick(long millisUntilFinished) {
            textV.setText("Tria la carta abans que s'acabi el temps: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            if (gameViewModel.getRoundNumber() < 5) {
                nextRound();
            } else {
                if (gameViewModel.getPlayerScore() < gameViewModel.getiAScore()) {
                    showToast("¡Ha ganado IA!");
                } else if (gameViewModel.getiAScore() > gameViewModel.getPlayerScore()) {
                    showToast("¡Ha ganado Player!");
                }
                finish();
            }
            gameViewModel.save_game(PreferencesProvider.providePreferences().getInt("user_id", 0));
        }
    };
 */
}
