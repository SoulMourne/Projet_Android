package com.firstapp.android.whacamole.score;

/**
 * Created by Jean-Paul on 13/03/2016.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firstapp.android.whacamole.R;


public class Score extends AppCompatActivity
{
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tableau des scores");
        setContentView(R.layout.activity_score);
    }



    public Score ()
    {
        points = 0;
    }

    public Score(String parPseudo)
    {
        points = 0;
    }

    public int getPoints()
    {
        return this.points;
    }

    public void setPoints(int parPoints)
    {
        this.points = parPoints;
    }

    public void addPoints (int addedPoints)
    {
        this.points += addedPoints;
    }

    public void removePoints (int removedPoints)
    {
        if (points > 0)
            this.points -= removedPoints;
        if (points < 0)
            this.points = 0;
    }
}
