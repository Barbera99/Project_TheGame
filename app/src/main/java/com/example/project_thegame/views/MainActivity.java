package com.example.project_thegame.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.project_thegame.R;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.User;
import com.example.project_thegame.viewModels.MainViewModel;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    Button playButton;
    Button selectDeck;
    MainViewModel mContr = new MainViewModel();



    ArrayList<Card> lCard = new ArrayList<Card>();

    Spinner lvlList;
    String diffSelected;
    final int REQ_CODE = 3;
    final int REQ_ROUND = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContr.setListCard();
        lvlList = findViewById(R.id.sLvl);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Easy");
        arrayList.add("Medium");
        arrayList.add("Hard");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        lvlList.setAdapter(arrayAdapter);
        lvlList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diffSelected = (String) adapterView.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        playButton = findViewById(R.id.playButton);
        selectDeck = findViewById(R.id.btnDeck);
        selectDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeckActivity.class);
                intent.putExtra("PlayerObject", mContr.getPlayer());
                startActivityForResult(intent,REQ_CODE);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(mContr.checkIfDeck() != 5){
                    showToast("Necesitas seleccionar cartas que dispones para crear tu mazo antes de la partida");
                } else {
                    Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);
                    gameActivity.putExtra("DiffS",diffSelected);
                    gameActivity.putExtra("PlayerObject",mContr.getPlayer());
                    startActivity(gameActivity);
                }
            }

        });
    }

    protected void showToast(String msg){
        Toast myToast = Toast.makeText(this,msg,Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER,0,0);
        myToast.show();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE) {
            mContr.setPlayer((User)data.getExtras().getParcelable("PlayerResult"));
        } else if(requestCode == REQ_ROUND){

        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }




}
