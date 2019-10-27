package com.example.last_try;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class One_more extends AppCompatActivity
        implements View.OnClickListener {
    Button button_gt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_more);
        button_gt4 = findViewById(R.id.button_gt4);
        button_gt4.setOnClickListener(this);
        }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(One_more.this, Last_mb.class);
        startActivity(intent);

    }
}
