package com.abedkhan.todoly;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class} ,version = 4)
public abstract class TodoRdatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    static TodoRdatabase todoRdatabase = null;

    public static TodoRdatabase getInstance(Context context) {
        if (todoRdatabase == null) {
            todoRdatabase = Room.databaseBuilder(context,
                            TodoRdatabase.class,
                            "Todo_DB")
                    .allowMainThreadQueries()
                    .build();

        }

        return todoRdatabase;

    }
}
