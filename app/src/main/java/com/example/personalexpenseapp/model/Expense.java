package com.example.personalexpenseapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "expense_table")
public class Expense {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expense_id")
    public long id;
    @ColumnInfo(name = "expense_title")
    public String title;

    public Expense( String title, long amount, Date date) {

        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    //public Expense() {
   // }

    @ColumnInfo(name = "expense_amount")
    public long amount;
    @ColumnInfo(name = "expense_date")
    public Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
