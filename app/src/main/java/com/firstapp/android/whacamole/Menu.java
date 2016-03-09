package com.firstapp.android.whacamole;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void go_to_game(View view){
        Intent intent1 = new Intent(Menu.this , WhacAMole.class);
        startActivity(intent1);
    }

    public void exit_app(View view){
        finish();
    }
}
