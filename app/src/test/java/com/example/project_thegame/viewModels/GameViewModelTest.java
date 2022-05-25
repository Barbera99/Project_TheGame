package com.example.project_thegame.viewModels;

import static org.junit.Assert.*;

import com.example.project_thegame.models.Card;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
public class GameViewModelTest {

    private GameViewModel gvm;

    @Before
    public void setGvm(){
        gvm = new GameViewModel();
    }

    @Test
    public void gvmNotNull(){
        assertNotNull(gvm);
    }

    @Test
    public void arrayListText() {
        Card c = new Card(-1, "test", -1, -1, -1, -1, -1, false, 1);
        int i = 1;
        ArrayList<String> s = gvm.arrayListText(c,i);
        assertEquals(s,gvm.arrayListText(c,i));
    }


    @Test
    public void nextRound() {
        ArrayList<String> s = gvm.nextRound();
        assertEquals(s,gvm.nextRound());
    }
}