package com.firstapp.android.whacamole.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.firstapp.android.whacamole.R;
import com.firstapp.android.whacamole.activity.Pseudo;


public class Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void go_to_pseudo(View view){
        Intent intent1 = new Intent(Menu.this , Pseudo.class);
        startActivity(intent1);
    }

    public void exit_app(View view){
        finish();
    }
}
