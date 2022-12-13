package com.abedkhan.todoly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.abedkhan.todoly.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Home extends AppCompatActivity implements TodoEditDelateListener {
    ActivityHomeBinding binding;
List<Todo>gettodoByDate;
TodoRdatabase todoRdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        gettodoByDate=new ArrayList<>();

        binding.additem.setOnClickListener(view -> {

            Intent intent = new Intent(this, Addtodo.class);
            startActivity(intent);

        });

        binding.work.setOnClickListener(view -> {
            Intent intent = new Intent(this, work.class);
            startActivity(intent);
        });

        binding.allTodo.setOnClickListener(view -> {
            Intent intent = new Intent(this, AllTodo.class);
            startActivity(intent);
        });

        binding.person.setOnClickListener(view -> {
            Intent intent = new Intent(this, personal.class);
            startActivity(intent);
        });

        binding.shopping.setOnClickListener(view -> {
            Intent intent = new Intent(this, shopping.class);
            startActivity(intent);
        });

        binding.health.setOnClickListener(view -> {
            Intent intent = new Intent(this, health.class);
            startActivity(intent);
        });


        Datashow();
        String today=getDateToday();


        binding.worklist.setText("Today you have to do "+TodoRdatabase.getInstance(Home.this).todoDao().gettodobyDate(today).size()+" task :");

        gettodoByDate=TodoRdatabase.getInstance(Home.this).todoDao().gettodobyDate(today);

if (gettodoByDate.size() == 0){

    binding.managetext.setText("Your todo List is "+TodoRdatabase.getInstance(Home.this).todoDao().gettodobyDate(today).size());
    binding.managetitle.setText("Manage your");
    binding.managetime.setText("time well");

}else {

    binding.managetitle.setText(TodoRdatabase.getInstance(Home.this).todoDao().gettodobyDate(today).get(0).getTitle());
    binding.managetime.setText(TodoRdatabase.getInstance(Home.this).todoDao().gettodobyDate(today).get(0).getTime());

    }

}


    private void Datashow() {

        String today=getDateToday();

        TodoAdapter todoAdapter=new TodoAdapter( TodoRdatabase.getInstance(Home.this).todoDao().gettodobyDate(today),Home.this,this);
        binding.todorecyclerview.setAdapter(todoAdapter);

    }

    private String getDateToday() {
        int date, month, year;
        Calendar calendar = Calendar.getInstance();

        date = calendar.get(Calendar.DATE);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        return date+"-"+(month+1) +"-" +year;
    }

    @Override
    public void delateTodo(Todo todo) {


        showAleart();
        todoRdatabase.todoDao().delate(todo);
        Datashow();
    }

    private void showAleart() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete");
        builder.setMessage("Are you want to Delete?");
        builder.setIcon(R.drawable.ic_baseline_delete_24);


        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {



            }
        });

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {




            }
        });

        AlertDialog dialog=builder.create();

        dialog.show();

    }

    @Override
    public void updateTodo(Todo todo) {

        Intent intent=new Intent(this,EditTodo.class);
        intent.putExtra("ID",todo.getId());
        intent.putExtra("status",todo.getDone_undone());
        intent.putExtra("health",todo.isCetagoryhelth());
        intent.putExtra("shopping",todo.isCetagoryshopping());
        intent.putExtra("personal",todo.isCetagorypersonal());
        intent.putExtra("work",todo.isCetagorywork());
        intent.putExtra("title",todo.getTitle());
        intent.putExtra("des",todo.getDiscription());
        intent.putExtra("priority",todo.getTodoPriority());
        intent.putExtra("time",todo.getTime());
        intent.putExtra("date",todo.getDate());
        startActivity(intent);

    }

    @Override
    public void status(Todo todo) {


        Datashow();

    }
}
