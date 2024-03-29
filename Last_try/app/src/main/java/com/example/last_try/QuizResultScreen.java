package com.example.last_try;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

public class QuizResultScreen extends AppCompatActivity {

    int userAnswer = 1300; //ответ пользователя
    double realSumPercent = 12.2; //на сколько процентов его реальные доходы больше/меньше
    String peopleName = "Путин В.В."; //ФИО чиновника
    int yearOfDeclaration = 2019; //год подачи декларации
    int realSumMoney = 121973; //размер всего состояния
    int moneyPerMonth = 123; //доход в месяц
    String placeholder = ""; // больше/меньше

    public void createNewSameActivity (View view){
//        get new data from server
        QuizResultScreen.this.finish();
        Intent intent = new Intent (this, QuizResultScreen.class);
        startActivity(intent);
    }



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

        double tenPercent = moneyPerMonth / 100 * 10;

        if (    (userAnswer >= (moneyPerMonth - tenPercent) && (userAnswer <= moneyPerMonth + tenPercent))  ) {
            resultImageOutlet.setBackgroundResource(R.drawable.trophy);
            resultTextOutlet.setText("Угадали");
            resultTextOutlet.setTextColor(Color.parseColor("#24FF00"));
        } else {
            resultImageOutlet.setBackgroundResource(R.drawable.error);
            resultTextOutlet.setText("Не угадали");
            resultTextOutlet.setTextColor(Color.parseColor("#E43F3F"));
        }

        userAnswerTextOutlet.setText(MessageFormat.format("Ваш вариант: {0,number,#}₽", userAnswer));

        if (userAnswer < moneyPerMonth) {
            placeholder = "больше";
        } else {
            placeholder = "меньше";
        }

        realSumPercentTextOutlet.setText(MessageFormat.format("Реальная сумма на {0,number,#}% {1}", realSumPercent, placeholder));
        peopleNameTextOutlet.setText(peopleName);
        yearOfDeclarationTextOutlet.setText(MessageFormat.format("Его доход за месяц {0,number,#}г.", yearOfDeclaration));
        realSumMoneyTextOutlet.setText(MessageFormat.format("{0,number,#}₽", realSumMoney));

    }
}
