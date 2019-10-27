package com.example.last_last;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class FirstActy extends AppCompatActivity
        implements View.OnClickListener {




    Button button_gt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_acty);

        button_gt = findViewById(R.id.button_gt);
        button_gt.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_gt:
                Intent intentbtn = new Intent(this, MainActivity.class);
                startActivity(intentbtn);
                break;
            default:
                break;
        }

    }


}
