package com.example.last_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Last_mb extends AppCompatActivity
    implements View.OnClickListener {
    Button button_gt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_mb);
        button_gt6 = findViewById(R.id.button_gt6);
        button_gt6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Last_mb.this, QuizResultScreen.class);
        startActivity(intent);

    }

}
