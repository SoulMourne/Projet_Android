package com.firstapp.android.whacamole.score;

/**
 * Created by Jean-Paul on 13/03/2016.
 */
public class Score
{
    private int points;
    private String pseudo;

    public Score ()
    {
        pseudo = "";
        points = 0;
    }

    public Score(String parPseudo)
    {
        pseudo = parPseudo;
        points = 0;
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public void setPseudo(String parPseudo)
    {
        this.pseudo = parPseudo;
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
