package com.firstapp.android.whacamole.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.firstapp.android.whacamole.R;
import com.firstapp.android.whacamole.game.Game;

import java.util.ArrayList;
import java.util.HashMap;

public class GameActivity extends AppCompatActivity
{

    private ArrayList<Button> boutons;
    private static final int NB_LIGNES = 5;
    private static final int NB_COLONNES = 5;
    private HashMap<Integer,LinearLayout> lignesLayout;

    public RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whac_amole);

        Bundle b = getIntent().getExtras();
        int manches = b.getInt("manches");
        String difficulte = b.getString("difficulte");

        lignesLayout = new HashMap<>();
        boutons = new ArrayList<>();

        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //p.weight = 1;
        param1.height=param1.width;
        LinearLayout colonneLayout = new LinearLayout(this);
        colonneLayout.setWeightSum(NB_COLONNES);
        colonneLayout.setLayoutParams(param1);
        colonneLayout.setOrientation(LinearLayout.VERTICAL);
        relativeLayout.addView(colonneLayout);

        for (int i = 0; i<NB_LIGNES; i++)
        {
            LinearLayout ligne = new LinearLayout(this);
            ligne.setWeightSum(NB_LIGNES);
            ligne.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
            ligne.setLayoutParams(param2);

            lignesLayout.put(i, ligne);
            colonneLayout.addView(ligne);
            for (int j = 0;j<NB_COLONNES; j++)
            {
                Button bouton = new Button(this);
                bouton.setText("");
                bouton.setClickable(false);
                bouton.setLayoutParams(param2);
                bouton.setHeight(bouton.getWidth());
                boutons.add(bouton);
                ligne.addView(bouton);
            }
        }
        //bdScores
        Game game = new Game(this,manches, difficulte);
        game.mancheSuivante();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

    public ArrayList<Button> getBoutons()
    {
        return boutons;
    }


}
