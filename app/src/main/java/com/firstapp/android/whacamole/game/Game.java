package com.firstapp.android.whacamole.game;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;

import com.firstapp.android.whacamole.activity.GameActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by android on 09/03/2016.
 */
public class Game
{
    private int numManche;
    private Manche currentManche;
    private GameActivity gameActivity;

    public Game(GameActivity parGameActivity)
    {
        gameActivity = parGameActivity;
        numManche = 1;
        currentManche = mancheSuivante();

    }

    public Manche mancheSuivante()
    {
        return new Manche(gameActivity, this);
    }
}
