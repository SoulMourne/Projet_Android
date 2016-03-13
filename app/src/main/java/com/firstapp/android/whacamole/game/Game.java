package com.firstapp.android.whacamole.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import com.firstapp.android.whacamole.activity.*;
import com.firstapp.android.whacamole.score.Score;

import java.util.Iterator;
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
            Iterator<Button> it = gameActivity.getBoutons().iterator();
            while (it.hasNext())
            {
                Button current = it.next();
                current.setOnTouchListener(null);
                current.getBackground().setColorFilter(Color.rgb(128, 128, 128), PorterDuff.Mode.MULTIPLY);
            }

            //Retour menu ou scores

            //Context context = gameActivity.getApplicationContext();
            //CharSequence text = "Fin de la partie";
            //int duration = Toast.LENGTH_SHORT;

            gameActivity.setTitle("Fin de la partie");
            //Toast toast = Toast.makeText(context, text, duration);
            return null;
        }
    }
}
