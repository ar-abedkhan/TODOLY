package com.abedkhan.todoly;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewholder extends RecyclerView.ViewHolder {
    TextView ttitle,tdate,ttime,tdelate;
            ImageView edit,delate;
            AppCompatButton tStatus;
   TextView personal,work,shopping,health,tpriority;

    public TodoViewholder(@NonNull View itemView) {
        super(itemView);

        ttitle=itemView.findViewById(R.id.todoname);
        personal = itemView.findViewById(R.id.cetagorypersonal);
        work = itemView.findViewById(R.id.cetagorywork);
        shopping = itemView.findViewById(R.id.cetagoryshopping);
        health = itemView.findViewById(R.id.cetagoryhealth);
        ttime=itemView.findViewById(R.id.todotime);
        tdate=itemView.findViewById(R.id.tododate);
        tStatus=itemView.findViewById(R.id.status_switch);
        edit=itemView.findViewById(R.id.edit);
        tdelate=itemView.findViewById(R.id.tododelaterbtn);
        tpriority=itemView.findViewById(R.id.todopriority);
    }
}
