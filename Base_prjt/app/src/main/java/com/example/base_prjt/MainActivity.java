package com.example.base_prjt;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.ramotion.fluidslider.FluidSlider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import com.example.base_prjt.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private VievPaperAdaptet adaptet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.view_pager);
        adaptet = new VievPaperAdaptet(getSupportFragmentManager());
        viewPager.setAdapter(adaptet);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        final FluidSlider slider = findViewById(R.id.fluidslider);
        slider.setBeginTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                Log.d("D", "setBeginTrackingListener");
                return Unit.INSTANCE;
            }
        });

        slider.setEndTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                Log.d("D", "setEndTrackingListener");
                return Unit.INSTANCE;
            }
        });

    }


}
