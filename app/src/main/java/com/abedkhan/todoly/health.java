package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.todoly.databinding.ActivityHealthBinding;

public class health extends AppCompatActivity implements TodoEditDelateListener{
ActivityHealthBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHealthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.additem.setOnClickListener(view -> {

            Intent intent=new Intent(this,Addtodo.class);
            startActivity(intent);

        });

        binding.backbtn.setOnClickListener(view -> {
            onBackPressed();
        });


        TodoAdapter todoAdapter=new TodoAdapter(
                TodoRdatabase.getInstance(this).todoDao().getTaskIsHealth(true),this,this);
        binding.healthrecyclerview.setAdapter(todoAdapter);


    }

    @Override
    public void delateTodo(Todo todo) {

    }

    @Override
    public void updateTodo(Todo todo) {

    }

    @Override
    public void status(Todo todo) {

    }
}