package com.example.project_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Player;

import java.util.ArrayList;

public class DeckActivity extends AppCompatActivity {
    Spinner spDeck1;
    Spinner spDeck2;
    Spinner spDeck3;
    Spinner spDeck4;
    Spinner spDeck5;
    ListView listCard1;
    ListView listCard2;
    ListView listCard3;
    ListView listCard4;
    ListView listCard5;
    Player player;
    Button btnSave;
    Deck newDeck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck);
        player = getIntent().getParcelableExtra("PlayerObject");
        ArrayList<Card> cList = player.getListOfCardsOwned();
        ArrayAdapter<Card> adapter = new ArrayAdapter<Card>(this, android.R.layout.simple_spinner_item, cList);

        btnSave = findViewById(R.id.bSave);
        spDeck1 = findViewById(R.id.deck_1);
        spDeck2 = findViewById(R.id.deck_2);
        spDeck3 = findViewById(R.id.deck_3);
        spDeck4 = findViewById(R.id.deck_4);
        spDeck5 = findViewById(R.id.deck_5);
        listCard1 = findViewById(R.id.lCard1);
        listCard2 = findViewById(R.id.lCard2);
        listCard3 = findViewById(R.id.lCard3);
        listCard4 = findViewById(R.id.lCard4);
        listCard5 = findViewById(R.id.lCard5);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        spDeck1.setAdapter(adapter);
        spDeck1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card) adapterView.getSelectedItem();
                displayCardList(card,1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spDeck2.setAdapter(adapter);
        spDeck2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card) adapterView.getSelectedItem();
                displayCardList(card,2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spDeck3.setAdapter(adapter);
        spDeck3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card) adapterView.getSelectedItem();
                displayCardList(card,3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spDeck4.setAdapter(adapter);
        spDeck4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card) adapterView.getSelectedItem();
                displayCardList(card,4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spDeck5.setAdapter(adapter);
        spDeck5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card) adapterView.getSelectedItem();
                displayCardList(card,5);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void getSelectedCard(View v){
        Card c1 = (Card) spDeck1.getSelectedItem();
        player.getPlayerDeck().add(c1);
    }
    public void displayCardList(Card c1,int i){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(c1.getName());
        arrayList.add(String.valueOf(c1.getStrenght()));
        arrayList.add(String.valueOf(c1.getSpeed()));
        arrayList.add(String.valueOf(c1.getAgility()));
        arrayList.add(String.valueOf(c1.getEndurance()));
        arrayList.add(String.valueOf(c1.getIntelligencie()));
        arrayList.add(String.valueOf(c1.getCategory()));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        if(i == 1){listCard1.setAdapter(arrayAdapter);
        } else if(i == 2){listCard2.setAdapter(arrayAdapter);
        } else if(i == 3){listCard3.setAdapter(arrayAdapter);
        } else if(i == 4){listCard4.setAdapter(arrayAdapter);
        } else if(i == 5){listCard5.setAdapter(arrayAdapter);}
    }
}