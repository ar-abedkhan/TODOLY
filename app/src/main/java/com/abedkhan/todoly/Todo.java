package com.abedkhan.todoly;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Todo {


    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo
    private String title,discription,done_undone,todoPriority,date,time,edit;

    @ColumnInfo
    private long dateMilies;

    @ColumnInfo
    private  boolean cetagoryhelth,cetagorypersonal,cetagorywork,cetagoryshopping;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDone_undone() {
        return done_undone;
    }

    public void setDone_undone(String done_undone) {
        this.done_undone = done_undone;
    }

    public String getTodoPriority() {
        return todoPriority;
    }

    public void setTodoPriority(String todoPriority) {
        this.todoPriority = todoPriority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public long getDateMilies() {
        return dateMilies;
    }

    public void setDateMilies(long dateMilies) {
        this.dateMilies = dateMilies;
    }

    public boolean isCetagoryhelth() {
        return cetagoryhelth;
    }

    public void setCetagoryhelth(boolean cetagoryhelth) {
        this.cetagoryhelth = cetagoryhelth;
    }

    public boolean isCetagorypersonal() {
        return cetagorypersonal;
    }

    public void setCetagorypersonal(boolean cetagorypersonal) {
        this.cetagorypersonal = cetagorypersonal;
    }

    public boolean isCetagorywork() {
        return cetagorywork;
    }

    public void setCetagorywork(boolean cetagorywork) {
        this.cetagorywork = cetagorywork;
    }

    public boolean isCetagoryshopping() {
        return cetagoryshopping;
    }

    public void setCetagoryshopping(boolean cetagoryshopping) {
        this.cetagoryshopping = cetagoryshopping;
    }
}
