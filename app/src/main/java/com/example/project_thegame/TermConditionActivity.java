package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TermConditionActivity extends AppCompatActivity {
    Button btnAccept;
    Button btnDeny;
    Intent resultInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_condition);
        resultInt = new Intent();
        btnAccept = findViewById(R.id.asd);
        btnDeny = findViewById(R.id.asdf);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("agreed", true);
                editor.apply();
                resultInt.putExtra("datBol",true);
                setResult(Activity.RESULT_OK, resultInt);
                finish();
            }
        });
        btnDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultInt.putExtra("datBol",false);
                setResult(Activity.RESULT_OK, resultInt);
                finish();
            }
        });

    }

}