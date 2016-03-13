package com.firstapp.android.whacamole.mecanism;

import android.os.Handler;

import com.firstapp.android.whacamole.game.Game;
import com.firstapp.android.whacamole.game.Manche;

/**
 * Created by Jean-Paul on 13/03/2016.
 */
public class MancheTimer extends Thread
{
    private long startTime;
    private int startSecond;
    private Game game;

    //runs without a timer by reposting this handler at the end of the runnable
    private Handler timerHandler;

    public MancheTimer (Game parGame)
    {
        game = parGame;
        startTime = 0;
        startSecond = (int) (System.currentTimeMillis()/1000);
        timerHandler = new Handler();
    }

    @Override
    public void run()
    {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);

        if (startSecond+3 > seconds)
            timerHandler.postDelayed(this, 500);
        else
            game.mancheSuivante();
    }
}
