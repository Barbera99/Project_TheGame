package com.example.project_thegame.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.media.Image;
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
    private GameViewModel gameViewModel;
    private ActivityGameBinding activityGameBinding;
    CountDownTimer mCountD;
    String diffSelected;


    /**
     * En el onCreate hem de definir variables, valors de textViews i seleccionar carta
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
        gameViewModel.randomAttribute();
        gameViewModel.play();

        gameViewModel.isGameEnded.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    showToast("Partida finalitzada");
                    if (gameViewModel.getEndGame() == 1){
                        showToast("Guanyador de la partida IA");
                    }
                    else{
                        showToast("Guanyador de la partida " + gameViewModel.player2_username.getValue());
                    }
                    gameViewModel.save_game(PreferencesProvider.providePreferences().getInt("user_id", 0));
                    mCountD.cancel();
                    finish();
                    goTo(MainActivity.class);
                }

            }
        });

         //CONTROLADOR DEL TEMPS MAXIM PER RONDA
         //DISPLAY DEL TEMPS MAXIM PER RONDA
         mCountD = new CountDownTimer(30000, 1000) {
         public void onTick(long millisUntilFinished) {
             gameViewModel.contador.setValue("Tria la carta abans que s'acabi el temps: " + millisUntilFinished / 1000);
         }
         public void onFinish() {
                nextRound();
         }
        };
        mCountD.start();
    }

    public void nextRound() {
        ArrayList<String> result = gameViewModel.nextRound();
        mCountD.cancel();
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

    public ImageView getImageView(int card_id) {
        ImageView iv = new ImageView(this);
        switch (card_id) {
            case 0:
                iv = (ImageView) findViewById(R.id.card_1);
                break;
            case 1:
                iv = (ImageView) findViewById(R.id.card_2);
                break;
            case 2:
                iv = (ImageView) findViewById(R.id.card_3);
                break;
            case 3:
                iv = (ImageView) findViewById(R.id.card_4);
                break;
            case 4:
                iv = (ImageView) findViewById(R.id.card_5);
                break;

        }
        return iv;
    }

    public void goTo(Class _class) {
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }


}