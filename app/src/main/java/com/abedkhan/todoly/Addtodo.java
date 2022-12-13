package com.abedkhan.todoly;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.abedkhan.todoly.databinding.ActivityAddtodoBinding;

import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Addtodo extends AppCompatActivity implements TodoEditDelateListener {
    ActivityAddtodoBinding binding;

    private int mYear, mMounth, mDay, mHour, mMunite;
    Calendar calendar;
    String priority;
    long todoTimemilis;
    boolean isHealthChecked=false, isShoppingChecked=false, isPersonalChecked=false, isWorkChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddtodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        calendar = Calendar.getInstance();


        binding.dateselect.setOnClickListener(v -> {

            mYear = calendar.get(Calendar.YEAR);
            mMounth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            binding.date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            calendar.set(Calendar.YEAR, year);
                            calendar.set(Calendar.MONTH, monthOfYear);
                            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                            todoTimemilis = calendar.getTimeInMillis();


                        }
                    }, mYear, mMounth, mDay);
            datePickerDialog.show();

        });


        binding.timeselect.setOnClickListener(v -> {

            mHour = calendar.get(Calendar.HOUR_OF_DAY);
            mMunite = calendar.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {


                            binding.time.setText(getTime(hourOfDay, minute));
                        }
                    }, mHour, mMunite, false);
            timePickerDialog.show();
        });


        binding.redioPriority.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton priorityBtn = findViewById(checkedId);
                priority = priorityBtn.getText().toString();
            }
        });



        binding.person1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.person1.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
                {
                    binding.person1.setBackgroundResource(R.drawable.buttonback);
                    isPersonalChecked = true;
                }
                else{
                    binding.person1.setBackgroundResource(R.drawable.cback);
                    isPersonalChecked = false;
                }
            }
        });

        binding.work1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.work1.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
                {
                    binding.work1.setBackgroundResource(R.drawable.buttonback);
                    isWorkChecked = true;
                }else{
                    binding.work1.setBackgroundResource(R.drawable.cback);
                    isWorkChecked = false;
                }
            }
        });

        binding.shopping1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.shopping1.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
                {
                    binding.shopping1.setBackgroundResource(R.drawable.buttonback);
                    isShoppingChecked = true;
                }else{
                    binding.shopping1.setBackgroundResource(R.drawable.cback);
                    isShoppingChecked = false;
                }
            }
        });

        binding.health1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.health1.getBackground().getConstantState() == getResources().getDrawable(R.drawable.cback).getConstantState()) //---checking if the background resources are same
                {
                    binding.health1.setBackgroundResource(R.drawable.buttonback);
                    isHealthChecked = true;
                }else{
                    binding.health1.setBackgroundResource(R.drawable.cback);
                    isHealthChecked= false;
                }
            }
        });







        binding.submitbtm.setOnClickListener(v -> {
            Log.i("log", "clicked: ");

            String title = binding.todotitle.getText().toString();
            String discription = binding.todoDiscription.getText().toString();
            String date = binding.date.getText().toString();
            String time = binding.time.getText().toString();

            if (title.equals("") & discription.equals("")) {
                Toast.makeText(this, "Requared filed", Toast.LENGTH_SHORT).show();
            } else {


                Todo todo = new Todo();
                todo.setTitle(title);
                todo.setDate(date);
                todo.setTime(time);
                todo.setDiscription(discription);
                todo.setCetagoryhelth(isHealthChecked);
                todo.setCetagorypersonal(isPersonalChecked);
                todo.setCetagoryshopping(isShoppingChecked);
                todo.setCetagorywork(isWorkChecked);
                todo.setDone_undone("Not Done");
                todo.setTodoPriority(priority);
                todo.setDateMilies(todoTimemilis);


                TodoRdatabase.getInstance(this).todoDao().insert(todo);
                Intent intent = new Intent(this, Home.class);

                Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
                Log.i("tag", "user added");
                startActivity(intent);


            }


        });


    }

    private String getTime(int hr, int min) {
        Time tme = new Time(hr, min, 0);
        Format formatter = new SimpleDateFormat("h:mm a");
        return formatter.format(tme);
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