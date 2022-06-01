package com.example.project_thegame.viewModels;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
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
    public MutableLiveData<Boolean> isGameEnded;
    public MutableLiveData<String> player1_username;
    public MutableLiveData<String> player2_username;
    public MutableLiveData<String> player1_scoreLiveData;
    public MutableLiveData<String> player2_scoreLiveData;
    public MutableLiveData<String> round_number;
    public MutableLiveData<String> contador;
    public MutableLiveData<String> roundAttribute;
    public MutableLiveData<ImageView> card_1LiveData;
    public MutableLiveData<ImageView> card_2LiveData;
    public MutableLiveData<ImageView> card_3LiveData;
    public MutableLiveData<ImageView> card_4LiveData;
    public MutableLiveData<ImageView> card_5LiveData;

    int player1_score;
    int player2_score;
    int player1_id;
    private  UserRepo userRepo;
    private  GameRepo gameRepo;
    private GameActivity gameActivity;
    private MainActivity mainActivity;
    ArrayList <Integer> alreadySelectedAttribute = new ArrayList<>();
    ArrayList <Card> alreadySelectedCard = new ArrayList<>();
    boolean ifEndGame = false;
    int roundNumber;
    int endGame;
    int random;
    Card iACard;
    Card cardSelected;
    Deck deckForIA = new Deck();
    int positionCard;
    String attributeActualRound;
    ArrayList<Card> user_deck = new ArrayList<>();
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


    public GameViewModel(){
        this.gameRepo = new GameRepo();
        this.userRepo = new UserRepo();
        this.isGameEnded = new MutableLiveData<>(false);
        this.player1_scoreLiveData = new MutableLiveData<>();
        this.player1_username = new MutableLiveData<>();
        this.player2_scoreLiveData = new MutableLiveData<>();
        this.player2_username = new MutableLiveData<>();
        this.round_number = new MutableLiveData<>();
        this.gameRepo.setGameViewModel(this);
        this.userRepo.setGameViewModel(this);
        this.contador = new MutableLiveData<>();
        this.card_1LiveData = new MutableLiveData<>();
        this.card_2LiveData = new MutableLiveData<>();
        this.card_3LiveData = new MutableLiveData<>();
        this.card_4LiveData = new MutableLiveData<>();
        this.card_5LiveData = new MutableLiveData<>();
        this.roundAttribute = new MutableLiveData<>();
        iACard = c;
        cardSelected = c;
        player1_score = 0;
        player2_score = 0;
        roundNumber = 1;
        random = 0;
    }

    public void play(){
        user_deck.add(card_1);
        user_deck.add(card_2);
        user_deck.add(card_3);
        user_deck.add(card_4);
        user_deck.add(card_5);
        this.player1_username.setValue("IA Bot");
        this.userRepo.getUserById(PreferencesProvider.providePreferences().getInt("user_id", 0));
        this.player1_scoreLiveData.setValue(Integer.toString(player1_score));
        this.player2_scoreLiveData.setValue(Integer.toString(player2_score));
        this.round_number.setValue(Integer.toString(roundNumber));
        this.roundAttribute.setValue(attributeActualRound);
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

    public ArrayList<String> arrayListText(Card c, int i){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(c.getName());
        arrayList.add("Força:"+c.getStrenght());
        arrayList.add("Velocitat:"+c.getSpeed());
        arrayList.add("Agilitat:"+c.getAgility());
        arrayList.add("Resistencia:"+c.getEndurance());
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
    public void save_game(int id_player2){
        this.player1_id = id_player2;
        Game game = new Game(1, id_player2, player1_score, player2_score);
        this.gameRepo.saveGame(id_player2, game);
    }

    /**
     * Comprovem si s'acaba la partida quan un dels jugadors assoleix 3 victories.
     * @return
     */
    public int ifendGame(){
        if (player1_score == 3){
                return 1;
        }
        else if(player2_score == 3){
                return 2;
        }
        return 0;
    }

    /**
     * Comprovem qui guanya la ronda.
     * @return result ArrayList Retorna el guanyador de la ronda.
     */
    protected ArrayList<String> checkRoundWinner(int attributePlayer, int attributeIA){
        ArrayList<String> result = new ArrayList<>();
        if(attributeIA > attributePlayer){
            player1_score++;
            result.add("IA");
            result.add(String.valueOf(attributeIA));
        } else {
            player2_score++;
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
        if(attributeActualRound == "Força"){
            result = checkRoundWinner(cardSelected.getStrenght(),iACard.getStrenght());
            result.add("Força");
        } else if(attributeActualRound == "Velocitat"){
            result = checkRoundWinner(cardSelected.getSpeed(),iACard.getSpeed());
            result.add("Velocitat");
        } else if(attributeActualRound == "Agilitat"){
            result = checkRoundWinner(cardSelected.getAgility(),iACard.getAgility());
            result.add("Agilitat");
        } else if(attributeActualRound == "Resistencia"){
            result = checkRoundWinner(cardSelected.getEndurance(),iACard.getEndurance());
            result.add("Resistencia");
        } else if(attributeActualRound == "Inteligencia"){
            result = checkRoundWinner(cardSelected.getIntelligencie(),iACard.getIntelligencie());
            result.add("Inteligencia");
        }
        if(player1_score == 3 || player2_score == 3){
            endGame = ifendGame();
            isGameEnded.setValue(true);
        }
        randomAttribute();
        cardSelected = c;
        return result;
    }

    /**
     *
     */
    protected void IAIntell(){
        if(attributeActualRound.equals("Força")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getStrenght() > iACard.getStrenght()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Velocitat")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getSpeed() > iACard.getSpeed()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Agilitat")){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                if(deckForIA.getArrayDeck().get(i).getAgility() > iACard.getAgility()){
                    iACard = deckForIA.getArrayDeck().get(i);
                }
            }
        } else if(attributeActualRound.equals("Resistencia")){
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

    /**
     * Metode per agafar un atribut de manera random per a la ronda.
     */
    public void randomAttribute(){
        random = new Random().nextInt((5-1)+1) + 1;
        if(!alreadySelectedAttribute.isEmpty()){
            while(alreadySelectedAttribute.contains(random)){
                random = new Random().nextInt((5-1)+1) + 1;
            }
        }
        if(random == 1 ){
            attributeActualRound = "Fuerza";
        } else if(random == 2 ){
            attributeActualRound = "Velocitat";
        } else if(random == 3 ){
            attributeActualRound = "Agilitat";
        } else if(random == 4){
            attributeActualRound = "Resistencia";
        } else if(random == 5){
            attributeActualRound = "Inteligencia";
        }
        alreadySelectedAttribute.add(random);
        this.roundAttribute.setValue(attributeActualRound);
    }

    /**
     * Metode per a realitzar els onclick de les cartes, amb el databinding.
     * @param card_id Indiquem la id de la carta escollida per l'usuari.
     */
    public void onclickedAt(int card_id){
        Log.d(TAG, "" + card_id);
        cardSelected = user_deck.get(card_id);
        if(!alreadySelectedCard.contains(cardSelected)) {
            alreadySelectedCard.add(cardSelected);

            ImageView imageview = gameActivity.getImageView(card_id);
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
            imageview.setColorFilter(filter);

            gameActivity.nextRound();
            round_number.setValue(Integer.toString(roundNumber));
            player1_scoreLiveData.setValue(Integer.toString(player1_score));
            player2_scoreLiveData.setValue(Integer.toString(player2_score));
        }
    }

    /**
     *
     * GETTERS I SETTERS
     */
    public int getPositionCard(){return positionCard;}
    public void setPositionCard(int pC){this.positionCard = pC;}
    public int getRoundNumber() {return roundNumber;}
    public void setRoundNumber(int rN){this.roundNumber = rN;}
    public String getAttributeActualRound() {return attributeActualRound;}
    public void setGameActivity(GameActivity gameActivity){this.gameActivity = gameActivity;}
    public void setMainActivity(MainActivity mainActivity){this.mainActivity = mainActivity;}
    public void setContador(MutableLiveData<String> contador) {
        this.contador = contador;
    }
    public int getEndGame(){
        return endGame;
    }
}
