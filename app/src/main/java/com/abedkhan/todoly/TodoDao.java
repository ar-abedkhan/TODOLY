package com.abedkhan.todoly;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {



    @Insert
    void insert(Todo todo);


    @Update
    void update (Todo todo);

    @Delete
    void delate(Todo todo);


    @Query("SELECT * FROM todo")
    List<Todo> getTodolist ();


    @Query("SELECT * FROM Todo WHERE date == :today")
    List<Todo> gettodobyDate (String today);


    @Query("SELECT * FROM Todo WHERE todoPriority == :priority")
    List<Todo>gettodobyPriority (String priority);

    @Query("SELECT * FROM Todo WHERE cetagorypersonal == :category")
    List<Todo> getTaskIsPersonal(boolean category);

    @Query("SELECT * FROM Todo WHERE cetagorywork == :category")
    List<Todo> getTaskIsOffice(boolean category);

    @Query("SELECT * FROM Todo WHERE cetagoryshopping == :category")
    List<Todo> getTaskIsShopping(boolean category);

    @Query("SELECT * FROM Todo WHERE cetagoryhelth == :category")
    List<Todo> getTaskIsHealth(boolean category);


}
