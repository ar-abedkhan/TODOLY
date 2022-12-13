package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.todoly.databinding.ActivityWorkBinding;

public class work extends AppCompatActivity implements TodoEditDelateListener{
    ActivityWorkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                binding=ActivityWorkBinding.inflate(getLayoutInflater());
                setContentView(binding.getRoot());

                binding.additem.setOnClickListener(view -> {
                    Intent intent=new Intent(this,Addtodo.class);
                    startActivity(intent);
                });

                binding.backbtn.setOnClickListener(view -> {
                    onBackPressed();
                });

        TodoAdapter todoAdapter=new TodoAdapter(
                       TodoRdatabase.getInstance(this).todoDao().getTaskIsOffice(true),this,this);
        binding.workrecyclerview.setAdapter(todoAdapter);



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