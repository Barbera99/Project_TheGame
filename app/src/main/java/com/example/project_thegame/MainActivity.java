package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Player;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    /**
     * Cartes,baralles i players per fer proves!
     *
     */
    public static Card carta1 = new Card(1, "Benito", 50, 50, 50, 50, 50, false, 0);
    public static Card carta2 = new Card(2, "Paco", 49, 49, 49, 49, 49, false, 3);

    static Deck deck1 = new Deck(carta1, carta1, carta1, carta1, carta1);
    static Deck deck2 = new Deck(carta2, carta2, carta2, carta2, carta2);

    static Player player1 = new Player(1, "ecgb", 0, 0, 0, deck1);
    static Player player2 = new Player(1, "ecgb", 0, 0, 0, deck1);

    public static Game game = new Game(player1,player2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton);
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