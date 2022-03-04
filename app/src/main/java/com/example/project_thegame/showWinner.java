package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class showWinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_winner);

        TextView rn = (TextView)findViewById(R.id.sh);
        rn.setText(String.valueOf(roundNumber));



    }
}