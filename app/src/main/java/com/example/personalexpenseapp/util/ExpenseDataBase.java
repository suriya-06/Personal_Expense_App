package com.example.personalexpenseapp.util;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.personalexpenseapp.data.ExpenseDao;
import com.example.personalexpenseapp.model.Expense;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Expense.class},version = 1,exportSchema = false)
@TypeConverters(Converter.class)
public abstract class ExpenseDataBase extends RoomDatabase {

    public static final String DATABASE_NAME="expense_database";
    public static final int THREADS=4;

    public static volatile ExpenseDataBase INSTANCE;

    public static ExecutorService executorService=Executors.newFixedThreadPool(THREADS);

    public static RoomDatabase.Callback sRoomDatabase=new Callback() {
        @Override
        public void onCreate(@NonNull  SupportSQLiteDatabase db) {
            super.onCreate(db);
            executorService.execute(()->{
                ExpenseDao expenseDao= INSTANCE.expenseDao();
                expenseDao.deleteAll();
            });
        }
    };

    public  static  ExpenseDataBase getDataBase(final Context context){
        if(INSTANCE==null){
            synchronized (context.getApplicationContext()){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),ExpenseDataBase.class,
                            DATABASE_NAME).addCallback(sRoomDatabase).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ExpenseDao expenseDao();
}
