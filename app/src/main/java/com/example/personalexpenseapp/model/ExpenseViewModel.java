package com.example.personalexpenseapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.personalexpenseapp.data.ExpenseDao;
import com.example.personalexpenseapp.data.ExpenseRepo;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {

    private ExpenseRepo expenseRepo;
    private LiveData<List<Expense>> allExpense;
    public ExpenseViewModel(@NonNull  Application application) {
        super(application);
        expenseRepo=new ExpenseRepo(application);
        allExpense=expenseRepo.getAllExpense();
    }
    public LiveData<List<Expense>> getAllExpense(){
        return allExpense;
    }

    public LiveData<List<Expense>> getExpense(long id){
        return expenseRepo.getExpense(id);
    }

    public void insert(Expense expense){
        expenseRepo.insert(expense);
    }

    public void update(Expense expense){
        expenseRepo.update(expense);
    }

    public void deleteAll(){
        expenseRepo.deleteAll();
    }

    public void delete(Expense expense){
        expenseRepo.delete(expense);
    }
}
