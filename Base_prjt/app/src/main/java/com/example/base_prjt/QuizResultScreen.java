package com.example.base_prjt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.widget.TextView;

public class QuizResultScreen extends AppCompatActivity {

    int userAnswer = 13546;
    double realSumPercent = 12.2; //round value
    String peopleName = "Putin V.V.";
    int yearOfDeclaration = 2019;
    int realSumMoney = 121;
    String placeholder = "";
    int moneyPerMonth = 123;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result_screen);

        AppCompatImageView resultImageOutlet = findViewById(R.id.resultImage);
        TextView resultTextOutlet = findViewById(R.id.resultText);
        TextView userAnswerTextOutlet = findViewById(R.id.userAnswerText);
        TextView realSumPercentTextOutlet = findViewById(R.id.realSumPercentText);
        TextView peopleNameTextOutlet = findViewById(R.id.peopleNameText);
        TextView yearOfDeclarationTextOutlet = findViewById(R.id.yearOfDeclarationText);
        TextView realSumMoneyTextOutlet = findViewById(R.id.realSumMoneyText);

//        double tenPercent = moneyPerMonth / 100 * 10;
//        System.out.println(tenPercent);
    }
}
