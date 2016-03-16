package com.firstapp.android.whacamole.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firstapp.android.whacamole.R;

public class Difficulte extends AppCompatActivity {

    TextView manches_text;
    Button manche_moins_btn;
    Button facile;
    Button moyen;
    Button difficile;
    Button cauchemar;
    String choix_difficulte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulte);
        manches_text=(TextView)findViewById(R.id.manches_text);
        manche_moins_btn = (Button) findViewById(R.id.manche_moins_btn);

        facile = (Button)findViewById(R.id.facile_btn);
        facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix_difficulte = facile.getText().toString();
                go_to_game();
            }
        });
        moyen = (Button)findViewById(R.id.moyen_btn);
        moyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix_difficulte = moyen.getText().toString();
                go_to_game();
            }
        });
        difficile = (Button)findViewById(R.id.difficile_btn);
        difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix_difficulte = difficile.getText().toString();
                go_to_game();
            }
        });
        cauchemar = (Button)findViewById(R.id.cauchemar_btn);
        cauchemar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix_difficulte = cauchemar.getText().toString();
                go_to_game();
            }
        });

        setTitle("Choisissez la difficulté");
    }

    public void go_to_game(){
        Bundle b = new Bundle();
        b.putString("difficulte", choix_difficulte);
        b.putInt("manches", Integer.parseInt(manches_text.getText().toString()));
        Intent intent2 = new Intent(Difficulte.this , GameActivity.class);
        intent2.putExtras(b);
        startActivity(intent2);
    }



    public void upManche(View view){
        CharSequence a=manches_text.getText();
        int num_manche = Integer.parseInt(a.toString());
            manches_text.setText(String.valueOf(num_manche += 1));
        if (num_manche > 1){
            manche_moins_btn.setVisibility(View.VISIBLE);
        }
    }

    public void downManche(View view){
        CharSequence b=manches_text.getText();
        int num_manche = Integer.parseInt(b.toString());
        manches_text.setText(String.valueOf(num_manche -= 1));
        if (num_manche <= 15){
            manche_moins_btn.setVisibility(View.INVISIBLE);
        }
    }
}
