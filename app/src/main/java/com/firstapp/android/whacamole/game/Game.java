package com.firstapp.android.whacamole.game;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Button;

import com.firstapp.android.whacamole.R;
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
    private String difficulte;
    private RelativeLayout relativeLayout;

    public Game(GameActivity parGameActivity, int parNbManches, String parDifficulte)
    {
        gameActivity = parGameActivity;
        numManche = 0;
        score = new Score();
        nbManches = parNbManches;
        difficulte = parDifficulte;

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


            gameActivity.setTitle("Fin de la partie");
            //Toast.makeText(gameActivity, "Votre Score: "+ this.getScore().getPoints(), Toast.LENGTH_LONG).show();
            AlertDialog.Builder fin_partie = new AlertDialog.Builder(gameActivity);
            fin_partie.setTitle("Votre Score: "+ this.getScore().getPoints());
            fin_partie.setCancelable(false);
            fin_partie.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    gameActivity.finish();
                }
            });
            AlertDialog alertDialog = fin_partie.create();
            alertDialog.show();

            return null;
        }
    }

    public String getDifficulte()
    {
        return this.difficulte;
    }
}
