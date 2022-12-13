package com.abedkhan.todoly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;

import com.abedkhan.todoly.databinding.ActivityAllTodoBinding;

public class AllTodo extends AppCompatActivity implements TodoEditDelateListener{
ActivityAllTodoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllTodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.additem.setOnClickListener(view -> {
            Intent intent=new Intent(this,Addtodo.class);
            startActivity(intent);
        });

        binding.backbtn.setOnClickListener(view -> {
            onBackPressed();
        });

        TodoAdapter todoAdapter=new TodoAdapter(
                TodoRdatabase.getInstance(this).todoDao().getTodolist(),this,this);
        binding.alltodorecyclerview.setAdapter(todoAdapter);

        binding.todocount.setText("You have total "+TodoRdatabase.getInstance(this).todoDao().getTodolist().size()+" Todo :");


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