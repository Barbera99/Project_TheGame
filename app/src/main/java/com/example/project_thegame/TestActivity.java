package com.example.project_thegame;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.ComponentActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project_thegame.R;
import com.example.project_thegame.databinding.ActivityMainBinding;

public class TestActivity extends AppCompatActivity {
    Button btnAccept;
    Button btnDeny;
    Intent resultInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        btnAccept = findViewById(R.id.btnAccept);
        btnDeny = findViewById(R.id.btnDeny);
        resultInt = getIntent();
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = 1;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        btnDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = 2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_CANCELED, resultIntent);
                finish();
            }
        });
    }
}