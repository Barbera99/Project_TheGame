package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_thegame.controllers.GameController;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Map;
import com.example.project_thegame.models.User;
import com.example.project_thegame.viewModels.GameViewModel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    GameController gameController;
    Game game;
    private GameViewModel gameViewModel;
    int roundNumber = 0;
    //player1
    int playerScore = 0;
    User player1;
    User playerIA;
    Map[] already_played;
    TextView txtViewRounds;
    TextView scorePlayerText;
    TextView scoreIAText;
    TextView textV;
    ImageView imgBlank;
    ImageView imgC1;
    ImageView imgC2;
    ImageView imgC3;
    ImageView imgC4;
    ImageView imgC5;
    ArrayList <Card> Deck;

    Deck easyDeck = new Deck();
    Deck mediumDeck = new Deck();
    Deck hardDeck = new Deck();
    public static Card easy1 = new Card(1, "Easy1", 30, 30, 10, 20, 10, false, 3);
    public static Card easy2 = new Card(2, "Easy2", 20, 20, 30, 10, 20, false, 1);
    public static Card easy3 = new Card(3, "Easy3", 10, 10, 20, 30, 30, false, 3);
    public static Card medium1 = new Card(4, "Medium1", 50, 40, 40, 60, 50, false, 3);
    public static Card medium2 = new Card(5, "Medium2", 40, 60, 50, 50, 60, false, 3);
    public static Card medium3 = new Card(6, "Medium3", 60, 50, 60, 40, 40, false, 2);
    public static Card hard1 = new Card(7, "Hard1", 80, 90, 60, 70, 70, false, 1);
    public static Card hard2 = new Card(8, "Hard2", 70, 60, 80, 70, 70, false, 2);
    public static Card hard3 = new Card(9, "Hard3", 80, 70, 60, 90, 80, false, 2);



    ListView listAttributes;
    ArrayList<ImageView> imgList = new ArrayList<>();
    CountDownTimer mCountD;
    String diffSelected;
    String attributeActualRound;
    Card iACard;
    Card cardSelected;
    Deck deckForIA = new Deck();
    int positionCard;

    //player2
    int iAScore = 0;

    //Hem d'implementar algo per controlar les cartes ja usades (un array)

    /**
     * En el onCreate hem de definir variables, valors de textViews i seleccionar carta
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        //player1 = getIntent().getParcelableExtra("PlayerObject");
        
        gameViewModel = new GameViewModel(game);

        Bundle extras  = getIntent().getExtras();
        iACard = new Card(9, "test", -1, -1, -1, -1, -1, false, 1);
        diffSelected = extras.getString("DiffS");
        easyDeck.add(easy1,1);
        easyDeck.add(easy2,2);
        easyDeck.add(easy3,3);
        easyDeck.add(easy2,4);
        easyDeck.add(easy1,5);
        mediumDeck.add(medium1,1);
        mediumDeck.add(medium2,2);
        mediumDeck.add(medium3,3);
        mediumDeck.add(medium1,4);
        mediumDeck.add(medium3,5);
        hardDeck.add(hard1,1);
        hardDeck.add(hard2,2);
        hardDeck.add(hard3,3);
        hardDeck.add(hard2,4);
        hardDeck.add(hard3,5);
        if(diffSelected.equals("Easy")){
            System.out.println("entres");
            deckForIA = easyDeck;
        }else if(diffSelected.equals("Medium")){
            System.out.println("entres");
            deckForIA = mediumDeck;
        }else if(diffSelected.equals("Hard")){
            System.out.println("entres");
            deckForIA = hardDeck;
        }
        System.out.println(deckForIA.getArrayDeck().size()+"perque");
        System.out.println(diffSelected);
        listAttributes = findViewById(R.id.listCard);
        imgBlank = findViewById(R.id.idImgBlank);
        imgC1 = findViewById(R.id.imgCard1);
        imgC2 = findViewById(R.id.imgCard2);
        imgC3 = findViewById(R.id.imgCard3);
        imgC4 = findViewById(R.id.imgCard4);
        imgC5 = findViewById(R.id.imgCard5);
        scorePlayerText = findViewById(R.id.scorePlayer1);
        scoreIAText = findViewById(R.id.scorePlayer2);
        txtViewRounds = findViewById(R.id.roundNumber);
        roundNumber++;
        txtViewRounds.setText("Round " + roundNumber);


        randomAttribute();
        Bitmap p = returnPaint(attributeActualRound,400);
        imgBlank.setImageBitmap(p);

        /*Bitmap p1 = returnPaint("1",1000);
        imgC1.setImageBitmap(p1);
        Bitmap p2 = returnPaint("2",1000);
        imgC2.setImageBitmap(p2);
        Bitmap p3 = returnPaint("3",1000);
        imgC3.setImageBitmap(p3);
        Bitmap p4 = returnPaint("4",1000);
        imgC4.setImageBitmap(p4);
        Bitmap p5 = returnPaint("5",1000);
        imgC5.setImageBitmap(p5);*/

        /*Definir variables al principi de la ronda
        Bundle b = getIntent().getExtras();
        if (b != null) {
            roundNumber = b.getInt("roundNumber");
            player1score = b.getInt("player1Score");
            player2score = b.getInt("player2Score");
        }*/
        

        imgC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = player1.getPlayerDeck().getArrayDeck().get(0);
                setListAttributes(c,1);
            }
        });
        imgC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = player1.getPlayerDeck().getArrayDeck().get(1);
                setListAttributes(c,2);
            }
        });
        imgC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = player1.getPlayerDeck().getArrayDeck().get(2);
                setListAttributes(c,3);
            }
        });
        imgC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = player1.getPlayerDeck().getArrayDeck().get(3);
                setListAttributes(c,4);
            }
        });
        imgC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = player1.getPlayerDeck().getArrayDeck().get(4);
                setListAttributes(c,5);
            }
        });

        //Seleccionar carta
        Button selectCard = findViewById(R.id.btnSelect);
        selectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(roundNumber < 5){
                    imgList.get(positionCard-1).setImageResource(R.drawable.border_white);
                    mCountD.cancel();
                    nextRound();
                } else {
                    if(playerScore < iAScore){
                        showToast("¡Ha ganado IA!");
                    } else if(iAScore > playerScore){
                        showToast("¡Ha ganado Player!");
                    }
                    finish();
                }

                //Comprovar les cartes seleccionades
                //La carta sempre es la mateixa ja que encara no tenim com seleccionar cartes
                //TODO

                //Comprovar qui ha guanyat
                //Mes avan s'ha de fer un metode fen servir la classe(mechanics)

                // Metode per comprovar si algun jugador ha guanyat 3 partides i mostrar el guanyador.
                /*if(gameController.check_winner()){
                    Intent showWinner = new Intent(getApplicationContext(), ShowWinnerActivity.class);
                    startActivity(showWinner);
                    finish();
                }

                //Seguent ronda
                System.out.println("Següent ronda");
                Intent newRound = new Intent(getApplicationContext(), RoundActivity.class);

                //Dades necessàries per a la següent ronda
                Bundle b = new Bundle();
                b.putInt("roundNumber", roundNumber+1);
                b.putInt("player1Id", 1);
                b.putInt("player2Id", 0);
                b.putInt("player1Score", player1score);
                b.putInt("player2Score", player2score);
                newRound.putExtras(b);

                startActivity(newRound);
                finish();*/
            }
        });


        /**
         * TIMERS
         *
         */
        //CONTROLADOR DEL TEMPS MAXIM PER RONDA
        //DISPLAY DEL TEMPS MAXIM PER RONDA
        textV = (TextView) findViewById( R.id.textTimer );
        mCountD = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textV.setText("Elige carta antes de que termine el tiempo: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if(roundNumber < 5){
                    nextRound();
                } else {
                    if(playerScore < iAScore){
                        showToast("¡Ha ganado IA!");
                    } else if(iAScore > playerScore){
                        showToast("¡Ha ganado Player!");
                    }
                    finish();
                }

            }
        };

        mCountD.start();


        imgList.add(imgC1);
        imgList.add(imgC2);
        imgList.add(imgC3);
        imgList.add(imgC4);
        imgList.add(imgC5);
    }
    protected void setListAttributes(Card c,int i){

        if(imgList.get(i-1).getDrawable().getConstantState() == getResources().getDrawable(R.drawable.blank).getConstantState()){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(c.getName());
            arrayList.add("Fuerza:"+c.getStrenght());
            arrayList.add("Velocidad:"+c.getSpeed());
            arrayList.add("Agilidad:"+c.getAgility());
            arrayList.add("Aguante:"+c.getEndurance());
            arrayList.add("Inteligencia:"+c.getIntelligencie());
            arrayList.add("Categoria:"+c.getCategory());
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
            listAttributes.setAdapter(arrayAdapter);
            positionCard = i;
            cardSelected = c;
        }
    }

    protected Bitmap returnPaint(String s,int size){
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.blank);
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

    protected void randomAttribute(){
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

    protected void nextRound(){
        randomAttribute();
        Bitmap p = returnPaint(attributeActualRound,400);
        imgBlank.setImageBitmap(p);
        roundNumber++;
        txtViewRounds.setText("Round " + roundNumber);
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
        if(result.get(0).equals("empate")){
            showToast("Ha quedado en empate con el valor" + result.get(1));
        } else {
            showToast("Ha ganado " + result.get(0) + " con el valor de " + result.get(1) + " en " + result.get(2));
        }

        mCountD.start();
    }
    protected ArrayList<String> checkWinner(int attributePlayer,int attributeIA){
        ArrayList<String> result = new ArrayList<>();
        if(attributeIA > attributePlayer){
            iAScore++;
            scoreIAText.setText(String.valueOf(iAScore));
            result.add("IA");
            result.add(String.valueOf(attributeIA));
        } else if(attributeIA < attributePlayer) {
            playerScore++;
            scorePlayerText.setText(String.valueOf(playerScore));
            result.add("Player");
            result.add(String.valueOf(attributePlayer));
        } else {
            result.add("empate");
            result.add(String.valueOf(attributeIA));
        }
        return result;
    }

    protected void IAIntell(){
        if(attributeActualRound == "Fuerza"){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                System.out.println(i+"Joan");
                if(deckForIA.getArrayDeck().get(i).getStrenght() > iACard.getStrenght()){
                    iACard.setStrenght(deckForIA.getArrayDeck().get(i).getStrenght());
                }
            }
        } else if(attributeActualRound == "Velocidad"){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                System.out.println(i+"Joan");
                if(deckForIA.getArrayDeck().get(i).getSpeed() > iACard.getSpeed()){
                    iACard.setSpeed(deckForIA.getArrayDeck().get(i).getSpeed());
                }
            }
        } else if(attributeActualRound == "Agilidad"){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                System.out.println(i+"Joan");
                if(deckForIA.getArrayDeck().get(i).getAgility() > iACard.getAgility()){
                    iACard.setAgility(deckForIA.getArrayDeck().get(i).getAgility());
                }
            }
        } else if(attributeActualRound == "Aguante"){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                System.out.println(i+"Joan");
                if(deckForIA.getArrayDeck().get(i).getEndurance() > iACard.getEndurance()){
                    iACard.setEndurance(deckForIA.getArrayDeck().get(i).getEndurance());
                }
            }
        } else if(attributeActualRound == "Inteligencia"){
            for (int i = 0; i<deckForIA.getSIZE();i++){
                System.out.println(i+"Joan");
                if(deckForIA.getArrayDeck().get(i).getIntelligencie() > iACard.getIntelligencie()){
                    iACard.setIntelligencie(deckForIA.getArrayDeck().get(i).getIntelligencie());
                }
            }
        }
    }
    protected void showToast(String msg){
        Toast myToast = Toast.makeText(this,msg ,Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.show();
    }
}