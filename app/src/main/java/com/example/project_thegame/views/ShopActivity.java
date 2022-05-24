package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.project_thegame.R;
import com.example.project_thegame.models.Deck;

public class ShopActivity extends AppCompatActivity {
    private static final String TAG = "ShopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ImageButton home;
        ImageButton deck;

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(MainActivity.class);
            }
        });

        deck = findViewById(R.id.deck);
        deck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(DeckActivity.class);
            }
        });
    }

    public void goTo(Class _class){
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }

}