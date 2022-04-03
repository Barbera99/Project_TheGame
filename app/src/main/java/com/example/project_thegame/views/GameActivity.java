package com.example.project_thegame.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.project_thegame.R;
import com.example.project_thegame.databinding.ActivityGameBinding;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.viewModels.GameViewModel;


public class GameActivity extends AppCompatActivity {
    GameViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chooseDeck();
        initDataBinding();

    }

    public void chooseDeck() {
        String [] decks = {"Baralla 1", "Baralla 2", "Baralla 3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una baralla");
        builder.setItems(decks, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on colors[which]
            }
        });
        builder.show();
    }

    private void initDataBinding() {
        viewModel.init();
        //Game game = new ViewModelProvider(this).get(Game.class);
        ActivityGameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        viewModel = new GameViewModel();

    }
}