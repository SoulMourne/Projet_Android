package com.firstapp.android.whacamole.game;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.firstapp.android.whacamole.activity.GameActivity;
import com.firstapp.android.whacamole.mecanism.MancheTimer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;

/**
 * Created by Jean-Paul on 13/03/2016.
 */
public class Manche
{
    private int nbMole;
    private static final int MAX_MOLES = 4;

    public Manche(GameActivity gameActivity, Game game)
    {
        Iterator<Button> it = gameActivity.getBoutons().iterator();

        while (it.hasNext())
        {
            final Button current = it.next();
            current.setClickable(true);
            current.getBackground().setColorFilter(Color.rgb(0, 0, 0), PorterDuff.Mode.MULTIPLY);
            current.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    current.getBackground().setColorFilter(Color.rgb(255, 128, 0), PorterDuff.Mode.MULTIPLY);
                    return true;
                }
            });
        }

        Random generator = new Random();
        nbMole = generator.nextInt(MAX_MOLES)+1;

        ArrayList<Integer> activeMoles = new ArrayList<>();
        for (int i = 0; i<nbMole; i++) {
            int numero = -1;
            while (numero < 0 || !activeMoles.contains(numero)) {
                numero = generator.nextInt(25);
                activeMoles.add(numero);
            }
            final Button current = gameActivity.getBoutons().get(numero);
            current.setClickable(true);
            current.getBackground().setColorFilter(Color.rgb(153, 0, 0), PorterDuff.Mode.MULTIPLY);
            current.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    current.getBackground().setColorFilter(Color.rgb(0, 153, 0), PorterDuff.Mode.MULTIPLY);
                    return true;
                }
            });
        }

        MancheTimer m = new MancheTimer(game);
        m.start();

    }
}
