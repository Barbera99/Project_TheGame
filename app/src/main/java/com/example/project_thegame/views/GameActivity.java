package com.example.project_thegame.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.project_thegame.R;
import com.example.project_thegame.databinding.ActivityGameBinding;
import com.example.project_thegame.models.Game;
import com.example.project_thegame.viewModels.GameViewModel;

import org.w3c.dom.Text;


public class GameActivity extends AppCompatActivity {
    private GameViewModel gameViewModel;
    private ActivityGameBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        gameViewModel.getGame().observe(this, new Observer<Game>() {
            @Override
            public void onChanged(@Nullable Game game) {
                TextView score_player2 = findViewById(R.id.scorePlayer2);
                score_player2.setText(game.getScore_player2());
                TextView score_player1 = findViewById(R.id.scorePlayer1);
                score_player1.setText(game.getScore_player1());
            }
        });
        //chooseDeck();
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
        //viewModel.init();
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        // Inflate view and obtain an instance of the binding class.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        binding.setGameviewModel(gameViewModel);
        binding.setLifecycleOwner(this);
    }
}