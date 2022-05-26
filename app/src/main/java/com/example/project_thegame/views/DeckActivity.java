package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.project_thegame.R;

public class DeckActivity extends AppCompatActivity {
    private static final String TAG = "DeckActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);
        ImageButton home = findViewById(R.id.home);
        ImageButton shop = findViewById(R.id.shop);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {goTo(MainActivity.class);}
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {goTo(ShopActivity.class);}
        });

    }
    public void goTo(Class _class){
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }
}