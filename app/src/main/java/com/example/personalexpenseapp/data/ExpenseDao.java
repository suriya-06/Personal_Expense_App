package com.example.personalexpenseapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.personalexpenseapp.model.Expense;

import java.util.List;

@Dao
public interface ExpenseDao {
    @Insert
    void insert(Expense expense);
    @Update
    void update(Expense expense);
    @Query("DELETE FROM expense_table")
    void deleteAll();
    @Delete
    void delete(Expense expense);
    @Query("SELECT * FROM expense_table")
    LiveData<List<Expense>> getAll();
    @Query("SELECT * FROM expense_table WHERE expense_table.expense_id ==:id")
    LiveData<List<Expense>> get(long id);
}
