package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.project_thegame.R;

public class TermConditionActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
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
                goTo(LoginActivity.class);
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
    public void goTo(Class _class) {
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }

}