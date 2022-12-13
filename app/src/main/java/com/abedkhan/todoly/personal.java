package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.todoly.databinding.ActivityPersonalBinding;

public class personal extends AppCompatActivity implements TodoEditDelateListener{
    ActivityPersonalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPersonalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

                binding.additem.setOnClickListener(view -> {

                    Intent intent=new Intent(this,Addtodo.class);
                    startActivity(intent);

                });
                binding.backbtn.setOnClickListener(view -> {
                    onBackPressed();
                });

        TodoAdapter todoAdapter=new TodoAdapter(
                TodoRdatabase.getInstance(this).todoDao().getTaskIsPersonal(true),this,this);
        binding.personalrecyclerview.setAdapter(todoAdapter);


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