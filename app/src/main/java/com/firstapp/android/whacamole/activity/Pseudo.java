package com.firstapp.android.whacamole.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firstapp.android.whacamole.R;

public class Pseudo extends AppCompatActivity {
    TextView manches_text;
    Button manche_moins_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);
        manches_text=(TextView)findViewById(R.id.manches_text);
        manche_moins_btn = (Button) findViewById(R.id.manche_moins_btn);


    }

    public void go_to_game(View view){
        Intent intent2 = new Intent(Pseudo.this , GameActivity.class);
        startActivity(intent2);
    }



    public void upManche(View view){
        CharSequence a=manches_text.getText();
        int num_manche = Integer.parseInt(a.toString());
            manches_text.setText(String.valueOf(num_manche+=1));
        if (num_manche > 1){
            manche_moins_btn.setVisibility(View.VISIBLE);
        }
    }

    public void downManche(View view){
        CharSequence b=manches_text.getText();
        int num_manche = Integer.parseInt(b.toString());
        manches_text.setText(String.valueOf(num_manche -= 1));
        if (num_manche == 1){
            manche_moins_btn.setVisibility(View.INVISIBLE);
        }
    }

}
