package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_thegame.R;
import com.example.project_thegame.controllers.GameController;
import com.example.project_thegame.databinding.ActivityGameBinding;
import com.example.project_thegame.models.Card;
import com.example.project_thegame.models.Deck;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.Map;
import com.example.project_thegame.models.User;
import com.example.project_thegame.utils.PreferencesProvider;
import com.example.project_thegame.viewModels.DeckViewModel;
import com.example.project_thegame.viewModels.GameViewModel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    private DeckViewModel deckViewModel;
    private GameViewModel gameViewModel;
    private ActivityGameBinding activityGameBinding;
    User player1;
    Deck pDeck;
    TextView txtViewRounds;
    TextView scorePlayerText;
    TextView scoreIAText;
    TextView textV;
    ImageView imgBlank;
    ImageView imgC1;
    ImageView imgC2;
    ImageView imgC3;
    ImageView imgC4;
    ImageView imgC5;
    ListView listAttributes;
    ArrayList<ImageView> imgList = new ArrayList<>();
    CountDownTimer mCountD;
    String diffSelected;


    /**
     * En el onCreate hem de definir variables, valors de textViews i seleccionar carta
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        // @Jordi: Bind the xml with the activity (ActivityLevelsBinding is auto generated).
        activityGameBinding = ActivityGameBinding.inflate(getLayoutInflater());
        // Set the Content of the xml to the view
        setContentView(activityGameBinding.getRoot());
        // Set the viewModel
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);

        initDataBinding();
        Bundle extras = getIntent().getExtras();
        diffSelected = extras.getString("DiffS");
        gameViewModel.setIADifficult(diffSelected);
        gameViewModel.setGameActivity(this);
        gameViewModel.play();


        gameViewModel.isGameSaved.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Log.d(TAG, "Partida finalitzada i guardada correctament a la base de dades.");
                    showToast("Partida finalitzada");
                    goTo(MainActivity.class);
                } else {
                    //Display Error
                    Log.d(TAG, "Partida finalitzada, però no guardada a la base de dades.");
                }
            }
        });
    }

    public void nextRound() {
        ArrayList<String> result = gameViewModel.nextRound();
        if (result.get(0).equals("empate")) {
            showToast("Ha quedado en empate con el valor" + result.get(1));
        } else {
            showToast("Ha ganado " + result.get(0) + " con el valor de " + result.get(1) + " en " + result.get(2));
        }
        mCountD.start();
    }

    protected void showToast(String msg) {
        Toast myToast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.CENTER, 0, 0);
        myToast.show();
    }

    private void initDataBinding() {
        activityGameBinding.setGameViewModel(gameViewModel);
        activityGameBinding.setLifecycleOwner(this);
    }

    public void goTo(Class _class) {
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }
}