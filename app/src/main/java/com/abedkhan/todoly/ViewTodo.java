package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.abedkhan.todoly.databinding.ActivityViewTodoBinding;

import java.util.ArrayList;
import java.util.List;

public class ViewTodo extends AppCompatActivity {
ActivityViewTodoBinding binding;
    String title,des,time,date,status,priority,work,health,shopping,personal,todono;
    int id;
List<Todo>todoList;

boolean isHealthChecked=false,isWorkChecked=false,isPersonalChecked=false,isShoppingChecked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewTodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


todoList=new ArrayList<>();
        Intent intent=getIntent();


id=intent.getIntExtra("ID",0);

String tn=String.valueOf(id);
        binding.todono.setText("Your ToDo No :"+ tn +1);

//
//
//        todono=Integer.valueOf(getText(id).toString());



        title=intent.getStringExtra("title");
        binding.todotitle.setText(title);

        time=intent.getStringExtra("time");
        binding.todotime.setText(time);

        date=intent.getStringExtra("date");
        binding.tododate.setText(date);

        des=intent.getStringExtra("des");
        binding.todoDiscription.setText(des);

        status=intent.getStringExtra("status");
        binding.todostatus.setText(status);



        work=intent.getStringExtra("work");
        binding.work.setText(work);

        health=intent.getStringExtra("health");
        binding.health.setText(health);

        personal=intent.getStringExtra("personal");
        binding.personal.setText(personal);

        shopping=intent.getStringExtra("shopping");
        binding.shopping.setText(shopping);


        priority=intent.getStringExtra("priority");
        binding.todopriority.setText(priority);

//        todono=intent.getStringExtra("ID");
//        binding.todono.setText("Your ToDo No :"+ todono +1);




//        binding.priority.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                RadioButton priorityBtn = findViewById(checkedId);
//                priority = priorityBtn.getText().toString();
//            }
//        });





    }
}