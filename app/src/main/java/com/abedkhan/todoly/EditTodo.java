package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abedkhan.todoly.databinding.ActivityEditTodoBinding;

import java.util.List;

public class EditTodo extends AppCompatActivity {
ActivityEditTodoBinding binding;
    String title,des,time,date,status,priority;
    boolean work,health,personal,shopping;
    int id;
    List<Todo> todoList;
    boolean isHealthChecked=false,isWorkChecked=false,isPersonalChecked=false,isShoppingChecked=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditTodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent=getIntent();


        work=intent.getBooleanExtra("work",false);
        String twork=String.valueOf(work);
        shopping=intent.getBooleanExtra("shopping",false);
        String tshopping=String.valueOf(shopping);
        health=intent.getBooleanExtra("health",false);
        String thealth=String.valueOf(health);
        personal=intent.getBooleanExtra("personal",false);
        String tpersonal=String.valueOf(personal);


        title=intent.getStringExtra("title");
        binding.todotitle.setText(title);

        time=intent.getStringExtra("time");
        binding.time.setText(time);

        date=intent.getStringExtra("date");
        binding.date.setText(date);

        des=intent.getStringExtra("des");
        binding.todoDiscription.setText(des);

        status=intent.getStringExtra("status");
        binding.todostatus.setText(status);

        twork=intent.getStringExtra("work");
        binding.work.setText(twork);

        thealth=intent.getStringExtra("health");
        binding.health.setText(thealth);

        tpersonal=intent.getStringExtra("personal");
        binding.personal.setText(tpersonal);

        tshopping=intent.getStringExtra("shopping");
        binding.shopping.setText(tshopping);






//        twork=intent.getStringExtra("work");
//        binding.work.setVisibility(View.VISIBLE);
//
//        thealth=intent.getStringExtra("health");
//        binding.health.setVisibility(View.VISIBLE);
//
//        tpersonal=intent.getStringExtra("personal");
//        binding.personal.setVisibility(View.VISIBLE);
//
//        tshopping=intent.getStringExtra("shopping");
//        binding.shopping.setVisibility(View.VISIBLE);
//

        priority=intent.getStringExtra("priority");
        binding.todopriority.setText(priority);


id=intent.getIntExtra("ID",0);






//
//        binding.personal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (binding.personal.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
//                {
//                    binding.personal.setBackgroundResource(R.drawable.buttonback);
//                    isPersonalChecked = true;
//                }
//                else{
//                    binding.personal.setBackgroundResource(R.drawable.cback);
//                    isPersonalChecked = false;
//                }
//            }
//        });
//
//        binding.work.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (binding.work.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
//                {
//                    binding.work.setBackgroundResource(R.drawable.buttonback);
//                    isWorkChecked = true;
//                }else{
//                    binding.work.setBackgroundResource(R.drawable.cback);
//                    isWorkChecked = false;
//                }
//            }
//        });
//
//        binding.shopping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (binding.shopping.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
//                {
//                    binding.shopping.setBackgroundResource(R.drawable.buttonback);
//                    isShoppingChecked = true;
//                }else{
//                    binding.shopping.setBackgroundResource(R.drawable.cback);
//                    isShoppingChecked = false;
//                }
//            }
//        });
//
//        binding.health.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (binding.health.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
//                {
//                    binding.health.setBackgroundResource(R.drawable.buttonback);
//                    isHealthChecked = true;
//                }else{
//                    binding.health.setBackgroundResource(R.drawable.cback);
//                    isHealthChecked= false;
//                }
//            }
//        });
//

//        if (todo.isCetagorypersonal()){
//            holder.personal.setVisibility(View.VISIBLE);
//        }if (todo.isCetagoryhelth()){
//            holder.health.setVisibility(View.VISIBLE);
//        }if (todo.isCetagoryshopping()){
//            holder.shopping.setVisibility(View.VISIBLE);
//        }if (todo.isCetagorywork()){
//            holder.work.setVisibility(View.VISIBLE);
//        }




        binding.submitbtm.setOnClickListener(view -> {


    title=binding.todotitle.getText().toString();
    des=binding.todoDiscription.getText().toString();
    time=binding.time.getText().toString();
    date=binding.date.getText().toString();
//    work=binding.work.getText().toString();
//    health=binding.health.getText().toString();
//    shopping=binding.shopping.getText().toString();
//    personal=binding.personal.getText().toString();
    priority=binding.todopriority.getText().toString();
    status=binding.todostatus.getText().toString();

    if (title.equals("")|| date.equals("")|| des.equals("")){
        Toast.makeText(this, "Filed is Empty.Can't update", Toast.LENGTH_SHORT).show();

    }else {
        Todo todo=new Todo();
        todo.setTitle(title);
        todo.setDiscription(des);
        todo.setDate(date);
        todo.setTime(time);
        todo.setId(id);
        todo.setCetagoryhelth(health);
        todo.setCetagorywork(work);
        todo.setCetagoryshopping(shopping);
        todo.setCetagorypersonal(personal);


        TodoRdatabase.getInstance(this).todoDao().update(todo);


        Intent intent1=new Intent(this,Home.class);
        startActivity(intent1);
        Toast.makeText(this, "Data Edited Successfully", Toast.LENGTH_SHORT).show();

    }


});





    }
}