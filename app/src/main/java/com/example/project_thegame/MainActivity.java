package com.example.project_thegame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Map;
import com.example.project_thegame.models.User;
import com.example.project_thegame.utils.PreferencesProvider;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private static final String TAG = "MainActivity";
    Button playButton;
    Button selectDeck;
    ArrayList<Card> lCard = new ArrayList<Card>();
    User player1;
    User player2;
    Map[] already_played;
    Game game;
    Spinner lvlList;
    String diffSelected;
    final int REQ_CODE = 1;
    final int REQ_ROUND = 2;
    /**
     * Cartes,baralles i players per fer proves!
     *
     */
     /* public static Card carta1 = new Card(1, "Benito", 50, 26, 44, 86, 51, false, 2);
    public static Card carta2 = new Card(2, "Paco", 20, 24, 94, 12, 89, false, 3);
    public static Card carta3 = new Card(1, "Mariano", 30, 30, 36, 38, 5, false, 1);
    public static Card carta4 = new Card(2, "Raimundo", 69, 28, 95, 15, 36, false, 3);
    public static Card carta5 = new Card(1, "Jaime", 10, 98, 72, 11, 10, false, 3);
    public static Card carta6 = new Card(2, "Jose", 29, 59, 61, 46, 98, false, 3);
    public static Card carta7 = new Card(1, "Fran", 40, 57, 59, 85, 83, false, 2);
    public static Card carta8 = new Card(2, "Gonzalo", 19, 29, 39, 23, 9, false, 1);
    public static Card carta9 = new Card(1, "Jon", 5, 53, 24, 83, 16, false, 2);
    public static Card carta10 = new Card(2, "Carlos", 16, 32, 51, 14, 94, false, 2); */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        lCard.add(carta1);
        lCard.add(carta2);
        lCard.add(carta3);
        lCard.add(carta4);
        lCard.add(carta5);
        lCard.add(carta6);
        lCard.add(carta7);
        lCard.add(carta8);
        lCard.add(carta9);
        lCard.add(carta10); */
        String token = PreferencesProvider.providePreferences().getString("token", "");
        Log.d(TAG,"token: " + token);
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
        game = new Game(player1,player2,already_played);
        playButton = findViewById(R.id.playButton);
        selectDeck = findViewById(R.id.btnDeck);
        selectDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeckActivity.class);
                intent.putExtra("PlayerObject", player1);
                startActivityForResult(intent,REQ_CODE);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.out.println(player1.getPlayerDeck().getArrayDeck().size() + "-------------");

                if(player1.getPlayerDeck().getArrayDeck().size() != 5){
                    showToast("Necesitas seleccionar cartas que dispones para crear tu mazo antes de la partida");
                } else {
                    Intent roundActivity = new Intent(getApplicationContext(), GameActivity.class);
                    roundActivity.putExtra("DiffS",diffSelected);

                    roundActivity.putExtra("PlayerObject",player1);

                    startActivity(roundActivity);
                }
                //finish();
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
            player1 = (User)data.getExtras().getParcelable("PlayerResult");
            System.out.println(player1.getName());
            System.out.println(player1.getPlayerDeck().getArrayDeck().get(0));
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
