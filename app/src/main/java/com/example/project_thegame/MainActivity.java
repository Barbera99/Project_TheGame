package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Player;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /**
     * Cartes,baralles i players per fer proves!
     *
     */
    public static Card carta1 = new Card(1, "Benito", 50, 50, 50, 50, 50, false, 0);
    public static Card carta2 = new Card(2, "Paco", 49, 49, 49, 49, 49, false, 3);

    Deck deck1 = new Deck(carta1, carta1, carta1, carta1, carta1);
    Deck deck2 = new Deck(carta2, carta2, carta2, carta2, carta2);

    Player player1 = new Player(1, "ecgb", 0, 0, 0, 0, 1, deck1);
    Player player2 = new Player(1, "ecgb", 0, 0, 0, 0, 1, deck1);


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
}