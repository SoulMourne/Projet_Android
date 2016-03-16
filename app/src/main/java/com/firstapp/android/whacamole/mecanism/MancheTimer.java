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
    private long startMillis;
    private Game game;
    private static final int temps[] = {2000,1500,1000,750};
    private int tempsChoisi;

    //runs without a timer by reposting this handler at the end of the runnable
    private Handler timerHandler;

    public MancheTimer (Game parGame)
    {
        game = parGame;
        startTime = 0;
        startMillis = System.currentTimeMillis();
        timerHandler = new Handler();
        switch (game.getDifficulte())
        {
            case "facile" :
                tempsChoisi = temps[0];
                break;
            case "moyen" :
                tempsChoisi = temps[1];
                break;
            case "difficile" :
                tempsChoisi = temps[2];
                break;
            case "cauchemar" :
                tempsChoisi = temps[3];
                break;
        }
    }

    @Override
    public void run()
    {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);

        if (startMillis+tempsChoisi > millis)
            timerHandler.postDelayed(this, 200);
        else
            game.mancheSuivante();
    }
}
