package com.firstapp.android.whacamole;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 09/03/2016.
 */
public class Game
{
    private int nbMole;

    public Game(WhacAMole whacAMole)
    {
        Random generator = new Random();
        nbMole = generator.nextInt(3)+1;

        ArrayList<Integer> activeMoles = new ArrayList<>();
        for (int i = 0; i<nbMole; i++)
        {
            int numero = -1;
            while (numero < 0 || !activeMoles.contains(numero))
            {
                numero = generator.nextInt(25);
                activeMoles.add(numero);
            }
            whacAMole.getBoutons().get(numero).setClickable(true);
            whacAMole.getBoutons().get(numero).setText("T");
        }
    }
}
