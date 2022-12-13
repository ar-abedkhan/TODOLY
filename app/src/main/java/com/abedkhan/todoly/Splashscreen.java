package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed((Runnable) () -> {

            Intent intent;

            SharedPreferences preferences = getSharedPreferences("WElcomescreen",MODE_PRIVATE);
            boolean isClicked = preferences.getBoolean("Uclick", false);

            if (isClicked){
                intent = new Intent(this, Home.class);
            }else {
                intent = new Intent(this, MainActivity.class);}
            startActivity(intent);
            finish();

        }, 1500);
    }
}