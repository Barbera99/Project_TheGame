package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project_thegame.controllers.GameController;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RoundActivity extends AppCompatActivity {
    GameController gameController;
    int roundNumber;
    //player1
    int player1score;
    Deck player1deck;
    Card player1card = MainActivity.carta1;

    //player2
    int player2score;
    Deck player2deck;
    Card player2card = MainActivity.carta2;

    //Hem d'implementar algo per controlar les cartes ja usades (un array)

    /**
     * En el onCreate hem de definir variables, valors de textViews i seleccionar carta
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        //Definir variables al principi de la ronda
        Bundle b = getIntent().getExtras();
        if (b != null) {
            roundNumber = b.getInt("roundNumber");
            player1score = b.getInt("player1Score");
            player2score = b.getInt("player2Score");
        }
        
        //Definim textviews
        TextView rn = (TextView)findViewById(R.id.txtRoundNumber);
        rn.setText(String.valueOf(roundNumber));
        TextView p1s = (TextView)findViewById(R.id.textPlayer1Score);
        p1s.setText(String.valueOf(player1score));
        TextView p2s = (TextView)findViewById(R.id.textPlayer2Score);
        p2s.setText(String.valueOf(player2score));


        //Seleccionar carta
        Button selectCard = findViewById(R.id.buttonSelectCard);
        selectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Comprovar les cartes seleccionades
                //La carta sempre es la mateixa ja que encara no tenim com seleccionar cartes
                //TODO

                //Comprovar qui ha guanyat
                //Mes avan s'ha de fer un metode fen servir la classe(mechanics)


                // Metode per comprovar si algun jugador ha guanyat 3 partides i mostrar el guanyador.
                if(gameController.check_winner()){
                    Intent showWinner = new Intent(getApplicationContext(), showWinner.class);
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
                finish();
            }
        });


        /**
         * TIMERS
         *
         */
        //CONTROLADOR DEL TEMPS MAXIM PER RONDA
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("TEMPS ACABAT");
            }
        };
        Timer temps = new Timer();
        temps.schedule(task, 20000);

        //DISPLAY DEL TEMPS MAXIM PER RONDA
        TextView _tv = (TextView) findViewById( R.id.textTimer );
        new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
                _tv.setText(new SimpleDateFormat("ss:SS").format(new Date( millisUntilFinished)));
            }
            public void onFinish() {
                _tv.setText("done!");
            }
        }.start();



    }
}