package com.firstapp.android.whacamole.game;

import android.content.Intent;
import android.view.View;

import com.firstapp.android.whacamole.activity.*;
import com.firstapp.android.whacamole.score.Score;

import java.util.Timer;

/**
 * Created by android on 09/03/2016.
 */
public class Game
{
    private int numManche;
    private Manche currentManche;
    private GameActivity gameActivity;
    private Score score;
    private int nbManches;
    private int violet;
    private int black;

    public Game(GameActivity parGameActivity, String pseudo, int parNbManches)
    {
        gameActivity = parGameActivity;
        numManche = 0;
        score = new Score(pseudo);
        nbManches = parNbManches;

    }

    public int getNumManche()
    {
        return this.numManche;
    }

    public Score getScore()
    {
        return this.score;
    }

    public Manche mancheSuivante()
    {
        if (numManche < nbManches)
        {
            this.numManche += 1;
            return new Manche(gameActivity, this);
        }
        else
        {
            //Retour menu ou scores
            gameActivity.setTitle("Fin de la partie");
            return null;
        }
    }
}
