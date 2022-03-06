package com.example.project_thegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.example.project_thegame.controllers.PlayerController;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    Button playButton;
    Button bTerms;
    Button selectDeck;
    /**
     * Cartes,baralles i players per fer proves!
     *
     */
    public static Card carta1 = new Card(1, "Benito", 50, 26, 44, 86, 51, false, 2);
    public static Card carta2 = new Card(2, "Paco", 20, 24, 94, 12, 89, false, 3);
    public static Card carta3 = new Card(1, "Mariano", 30, 30, 36, 38, 5, false, 1);
    public static Card carta4 = new Card(2, "Raimundo", 69, 28, 95, 15, 36, false, 3);
    public static Card carta5 = new Card(1, "Jaime", 10, 98, 72, 11, 10, false, 3);
    public static Card carta6 = new Card(2, "Jose", 29, 59, 61, 46, 98, false, 3);
    public static Card carta7 = new Card(1, "Fran", 40, 57, 59, 85, 83, false, 2);
    public static Card carta8 = new Card(2, "Gonzalo", 19, 29, 39, 23, 9, false, 1);
    public static Card carta9 = new Card(1, "Jon", 5, 53, 24, 83, 16, false, 2);
    public static Card carta10 = new Card(2, "Carlos", 16, 32, 51, 14, 94, false, 2);


    ArrayList<Card> lCard = new ArrayList<Card>();

    Player player1;
    Player player2;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lCard.add(carta1);
        lCard.add(carta2);
        lCard.add(carta3);
        lCard.add(carta4);
        lCard.add(carta5);
        lCard.add(carta6);
        lCard.add(carta7);
        lCard.add(carta8);
        lCard.add(carta9);
        lCard.add(carta10);

        player1 = new Player(1, "Test 1", 0, 0, 0, lCard);
        player2 = new Player(1, "Test 2", 0, 0, 0, lCard);
        game = new Game(player1,player2);
        playButton = findViewById(R.id.playButton);
        bTerms = findViewById(R.id.terms);
        selectDeck = findViewById(R.id.btnDeck);
        bTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent termsCond = new Intent(MainActivity.this, TestActivity.class);
                startActivity(termsCond);
            }
        });
        selectDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeckActivity.class);
                System.out.println(player1.getPlayerDeck().getArrayDeck());
                System.out.println(player1.getListOfCardsOwned().get(0).getCategory());
                intent.putExtra("PlayerObject", player1);
                startActivity(intent);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.out.println("BOTO APRETAT");


                Intent roundActivity = new Intent(getApplicationContext(), RoundActivity.class);

                //Dades
                Bundle b = new Bundle();
                b.putInt("roundNumber", 1);
                b.putInt("player1Id", 1);
                b.putInt("player2Id", 0);
                b.putInt("player1Score", 0);
                b.putInt("player2Score", 0);

                roundActivity.putExtras(b);

                startActivity(roundActivity);
                //finish();
            }

        });
    }


    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }




}
