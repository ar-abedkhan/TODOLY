package com.abedkhan.todoly;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewholder>{

    List<Todo> todoList;
    Context context;
    TodoEditDelateListener listener;


    public TodoAdapter(List<Todo> todoList, Context context, TodoEditDelateListener listener) {
        this.todoList = todoList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TodoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.todolistdesign,parent,false);

        return new TodoViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewholder holder, int position) {


        Todo todo=todoList.get(position);

        holder.ttitle.setText(todo.getTitle());
        holder.ttime.setText(todo.getTime());
        holder.tdate.setText(todo.getDate());
        holder.edit.setImageResource(R.drawable.edit);
        holder.tStatus.setText(todo.getDone_undone());
        holder.tpriority.setText(todo.getTodoPriority());

   if (todo.isCetagorypersonal()){
       holder.personal.setVisibility(View.VISIBLE);
   }if (todo.isCetagoryhelth()){
       holder.health.setVisibility(View.VISIBLE);
   }if (todo.isCetagoryshopping()){
       holder.shopping.setVisibility(View.VISIBLE);
   }if (todo.isCetagorywork()){
       holder.work.setVisibility(View.VISIBLE);
        }

   String status=todo.getDone_undone();

        Log.i("tag", "Done_undone1: "+status);
           holder.tStatus.setOnClickListener(view -> {

             if (status.equals("Not Done")){
                 Log.i("tag", "Done_undone2: ");

                 todo.setDone_undone("Done");
                 TodoRdatabase.getInstance(context).todoDao().update(todo);
                 holder.tStatus.setText(todo.getDone_undone());
                 holder.tStatus.setBackgroundResource(R.drawable.back);
//                 holder.tStatus.setBackgroundColor(Color.red(R.color.purple_200));

             }else {
                 todo.setDone_undone("Not Done");
                 TodoRdatabase.getInstance(context).todoDao().update(todo);
                 holder.tStatus.setText(todo.getDone_undone());
                 holder.tStatus.setBackgroundResource(R.drawable.back2);

             }
            listener.status(todo);
           });


//
//    if (todo.getTodoPriority().equals("High")){
//        holder.tpriority.setText("High");
//    }if (todo.getTodoPriority().equals("Medium")){
//        holder.tpriority.setText("Medium");
//    }if (todo.getTodoPriority().equals("Low")){
//        holder.tpriority.setText("Low");
//    }


//
//       holder.tdelate.setOnClickListener(view -> {
//
//           listener.delateTodo(todo);
//       });



        holder.edit.setOnClickListener(view -> {

              listener.updateTodo(todo);

        });

        holder.itemView.setOnClickListener(view -> {

            Intent intent=new Intent(context,ViewTodo.class);
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
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}