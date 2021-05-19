package com.example.personalexpenseapp.data;

import android.app.Application;
import android.app.TaskInfo;

import androidx.lifecycle.LiveData;

import com.example.personalexpenseapp.model.Expense;
import com.example.personalexpenseapp.util.ExpenseDataBase;

import java.util.List;

public class ExpenseRepo {

    private ExpenseDao expenseDao;
    private LiveData<List<Expense>> allExpense;

    public ExpenseRepo(Application application) {
        ExpenseDataBase expenseDataBase=ExpenseDataBase.getDataBase(application.getApplicationContext());
        expenseDao = expenseDataBase.expenseDao();
        allExpense = expenseDao.getAll();
    }

    public LiveData<List<Expense>> getAllExpense(){
        return allExpense;
    }
    public LiveData<List<Expense>> getExpense(long id){
        return expenseDao.get(id);
    }
    public void insert(Expense expense){
       ExpenseDataBase.executorService.execute(()->{
           expenseDao.insert(expense);
        });
    }
    public void update(Expense expense){
        ExpenseDataBase.executorService.execute(()->{
            expenseDao.update(expense);
        });
    }
    public void deleteAll(){
        ExpenseDataBase.executorService.execute(()->{
            expenseDao.deleteAll();
        });
    }
    public void delete(Expense expense){
        ExpenseDataBase.executorService.execute(()->{
            expenseDao.delete(expense);
        });
    }
}
