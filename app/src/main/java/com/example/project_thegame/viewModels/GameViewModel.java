package com.example.project_thegame.viewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project_thegame.models.Game;
import com.example.project_thegame.models.User;

public class GameViewModel extends ViewModel {
    private MutableLiveData<Game> game;

    public MutableLiveData<Game> getGame() {
        if (game == null) {
            game = new MutableLiveData<>();
        }
            return game;
    }


    public void init() {
        User p = new User();
        p.setId(1);
        p.setName("Aleix");
        User ia = new User();
        p.setId(2);
        ia.setName("IA");
        game = new Game(p.getId(), ia.getId(), 0, 0);
    }
}
