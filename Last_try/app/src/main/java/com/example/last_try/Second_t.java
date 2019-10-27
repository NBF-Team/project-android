package com.example.last_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second_t extends AppCompatActivity
        implements View.OnClickListener {
    Button button_gt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_t);
        button_gt3 = findViewById(R.id.button_gt3);
        button_gt3.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Second_t.this, One_more.class);
        startActivity(intent);

    }
}

