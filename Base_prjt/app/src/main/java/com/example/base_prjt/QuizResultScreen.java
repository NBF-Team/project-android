package com.example.base_prjt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizResultScreen extends AppCompatActivity {

    int userAnswer = 13546;
    double realSumPercent = 12.2; //round value
    String peopleName = "Putin V.V.";
    int yearOfDeclaration = 2019;
    int realSumMoney = 121;
    String placeholder = "";
    int moneyPerMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result_screen);

        System.out.println(moneyPerMonth);
    }
}
