package com.example.personalexpenseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.personalexpenseapp.model.Expense;
import com.example.personalexpenseapp.model.ExpenseViewModel;
import com.google.android.material.badge.BadgeUtils;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    ExpenseViewModel expenseViewModel;
    TextView textView;
    Expense expense;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.hehe);
        button=findViewById(R.id.button);
        expenseViewModel=new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication())
                .create(ExpenseViewModel.class);


        button.setOnClickListener(view -> {

            expense=new Expense("Diary Milk",20, Calendar.getInstance().getTime());

            expenseViewModel.insert(expense);


        });



    }
}