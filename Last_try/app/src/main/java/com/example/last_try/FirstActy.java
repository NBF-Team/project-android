package com.example.last_try;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;


public class FirstActy extends AppCompatActivity implements  View.OnClickListener {
    Button button_gt;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_acty);
        button_gt = findViewById(R.id.button_gt);
        button_gt.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_gt:
                Intent intentbtn = new Intent(this, MainActivity.class);
                startActivity(intentbtn);
            case R.id.button2:
                Intent intentbtn2 = new Intent(this, Ranking.class);
                startActivity(intentbtn2);
            case R.id.button3:
                Intent intentbtn3 = new Intent(this, Search.class);
                startActivity(intentbtn3);
                break;
            default:
                break;
        }
    }
}
