package com.example.last_try;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    Button button_gt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_gt = findViewById(R.id.button_gt);
        button_gt.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Second_t.class);
        startActivity(intent);
    }
}


