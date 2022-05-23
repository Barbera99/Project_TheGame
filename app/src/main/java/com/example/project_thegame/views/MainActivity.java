package com.example.project_thegame.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

import com.example.project_thegame.R;
import com.example.project_thegame.databinding.ActivityMainBinding;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.User;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.viewModels.LogOutViewModel;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private static final String TAG = "MainActivity";
    private LogOutViewModel logOutViewModel;
    private ActivityMainBinding activityMainBinding;


    Button playButton;
    Button selectDeck;
    Button logoutButton;
    ArrayList<Card> lCard = new ArrayList<Card>();
    User player1;
    User player2;
    Game game;
    Spinner lvlList;
    String diffSelected;
    final int REQ_CODE = 1;
    final int REQ_ROUND = 2;

    //TODO: @Didac Aquesta pantalla pot millorar. Una Imatge o el vostre logo quedaria millor i no es veuria un espai tant buit.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logOutViewModel = new LogOutViewModel();
        logOutViewModel.setMainActivity(this);
        initDataBinding();

        logOutViewModel.isLoggedOut.observe(this, new androidx.lifecycle.Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    Log.d(TAG,"SignOut correctly done");
                    showToast("Sessió tancada correctament.");
                    PreferencesProvider.providePreferences().edit().putString("token","").commit();
                    goTo(LoginActivity.class);
                }else{
                    //Display Error
                    Log.d(TAG,"SignOut not correctly done.");
                }
            }
        });


        lvlList = findViewById(R.id.sLvl);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Easy");
        arrayList.add("Medium");
        arrayList.add("Hard");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        lvlList.setAdapter(arrayAdapter);
        lvlList.setSelection(0);
        lvlList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diffSelected = (String) adapterView.getSelectedItem();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //TODO @Didac. Perque? Dijous comentem.
        selectDeck = findViewById(R.id.btnDeck);
        selectDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeckActivity.class);
                intent.putExtra("PlayerObject", player1);
                startActivity(intent);
            }
        });

        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                    Intent gameActivity = new Intent(getApplicationContext(), GameActivity.class);
                    gameActivity.putExtra("DiffS",diffSelected);
                    //gameActivity.putExtra("PlayerObject",player1);
                    startActivity(gameActivity);
                //finish();
            }

        });

        logoutButton = findViewById(R.id.LogOut);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteToken = PreferencesProvider.providePreferences().getString("token","");
                logOutViewModel.logOut(deleteToken);
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

    private void initDataBinding() {
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setLogOutViewModel(logOutViewModel);
        activityMainBinding.setLifecycleOwner(this);
    }

    public void goTo(Class _class){
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }
}
