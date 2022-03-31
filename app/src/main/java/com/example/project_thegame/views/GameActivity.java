package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_thegame.R;
import com.example.project_thegame.viewModels.GameViewModel;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    GameViewModel gContr;

    //------TextView------
    TextView txtViewRounds;
    TextView scorePlayerText;
    TextView scoreIAText;
    TextView textV;
    //------ImageView------
    ImageView imgBlank;
    ImageView imgC1;
    ImageView imgC2;
    ImageView imgC3;
    ImageView imgC4;
    ImageView imgC5;
    //------Var------
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
        setContentView(R.layout.activity_game);
        //------findViewById------
        imgC1 = findViewById(R.id.imgCard1);
        imgC2 = findViewById(R.id.imgCard2);
        imgC3 = findViewById(R.id.imgCard3);
        imgC4 = findViewById(R.id.imgCard4);
        imgC5 = findViewById(R.id.imgCard5);
        listAttributes = findViewById(R.id.listCard);
        imgBlank = findViewById(R.id.idImgBlank);
        scorePlayerText = findViewById(R.id.scorePlayer1);
        scoreIAText = findViewById(R.id.scorePlayer2);
        txtViewRounds = findViewById(R.id.roundNumber);
        textV = (TextView) findViewById( R.id.textTimer );
        Button selectCard = findViewById(R.id.btnSelect);

        //------gettingInfo------
        gContr.setPlayer(getIntent().getParcelableExtra("PlayerObject"));
        Bundle extras  = getIntent().getExtras();
        diffSelected = extras.getString("DiffS");

        //------settingInfo------
        iACard = new Card(-1, "test", -1, -1, -1, -1, -1, false, 1);
        gContr.setIADifficult(diffSelected);
        txtViewRounds.setText("Round " + gContr.getRoundNumber());
        gContr.randomAttribute();
        Bitmap p = returnPaint(attributeActualRound,400);
        imgBlank.setImageBitmap(p);

        //------OnClickListener------
        imgC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = gContr.getCardSelected(0);
                setListAttributes(c,1);
            }
        });
        imgC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = gContr.getCardSelected(1);
                setListAttributes(c,2);
            }
        });
        imgC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = gContr.getCardSelected(2);
                setListAttributes(c,3);
            }
        });
        imgC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = gContr.getCardSelected(3);
                setListAttributes(c,4);
            }
        });
        imgC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Card c = gContr.getCardSelected(4);
                setListAttributes(c,5);
            }
        });
        selectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    nextRound();
            }
        });


        mCountD = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textV.setText("Elige carta antes de que termine el tiempo: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                nextRound();

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
            ArrayList<String> arrayList = gContr.arrayListText(c,i);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
            listAttributes.setAdapter(arrayAdapter);
        }
    }

    protected Bitmap returnPaint(String s,int size){
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.blank);
        Bitmap newImage = gContr.getConfPaint(bm,s,size);
        return newImage;
    }

    public void nextRound(){
        if(gContr.getRoundNumber() < 5){
            imgList.get(positionCard-1).setImageResource(R.drawable.border_white);
            mCountD.cancel();
            Bitmap p = returnPaint(attributeActualRound,400);
            imgBlank.setImageBitmap(p);
            txtViewRounds.setText("Round " + gContr.getRoundNumber());
            ArrayList<String> result = gContr.nextRound();
            if(result.get(0).equals("empate")){
                showToast("Ha quedado en empate con el valor" + result.get(1));
            } else {
                showToast("Ha ganado " + result.get(0) + " con el valor de " + result.get(1) + " en " + result.get(2));
            }
            scorePlayerText.setText(String.valueOf(gContr.getPlayerScore()));
            scoreIAText.setText(String.valueOf(gContr.getiAScore()));

            mCountD.start();
        } else {
            if(gContr.getPlayerScore() < gContr.getiAScore()){
                showToast("¡Ha ganado IA!");
            } else if(gContr.getiAScore() > gContr.getPlayerScore()){
                showToast("¡Ha ganado Player!");
            }
            finish();
        }
    }





    protected void showToast(String msg){
        Toast myToast = Toast.makeText(this,msg ,Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.show();
    }
}