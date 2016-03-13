package com.firstapp.android.whacamole;

/**
 * Created by Jean-Paul on 13/03/2016.
 */
public class Score
{
    private int score;
    private String pseudo;

    public Score(String parPseudo)
    {
        pseudo = parPseudo;
        score = 0;
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public void setPseudo(String parPseudo)
    {
        this.pseudo = parPseudo;
    }

    public int getScore()
    {
        return this.score;
    }

    public void setScore(int parScore)
    {
        this.score = parScore;
    }

    public void addPoints (int addedPoints)
    {
        this.score += addedPoints;
    }

    public void removePoints (int removedPoints)
    {
        this.score -= removedPoints;
    }
}
