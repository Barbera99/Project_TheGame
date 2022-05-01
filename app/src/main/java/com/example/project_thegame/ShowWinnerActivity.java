package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowWinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_winner);

        TextView rn = (TextView)findViewById(R.id.winner);
        //rn.setText(String.valueOf(roundNumber));

    }
}