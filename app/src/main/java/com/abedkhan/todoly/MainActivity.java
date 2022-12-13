package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.abedkhan.todoly.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences=getSharedPreferences("WElcomescreen",MODE_PRIVATE);


        binding.mainsubmitbtm.setOnClickListener(view -> {
            SharedPreferences.Editor editor=preferences.edit();
            editor.putBoolean("Uclick",true);
            editor.apply();

            Intent intent=new Intent(this,Home.class);
            startActivity(intent);
        });




    }
}