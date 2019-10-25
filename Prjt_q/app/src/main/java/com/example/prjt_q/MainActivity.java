package com.example.prjt_q;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.prjt_q.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs_1);
        tabs.setupWithViewPager(viewPager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onClick(View view) {
        // Handle navigation view item clicks here.

    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        int id = item.getItemId()   ;

        if (id == R.id.nav_main_1) {
            setTitle("Co-Working list");
            Frag_1_1 fragment = new Frag_1_1();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.tabs_1, fragment,"Hello" );
            fragmentTransaction.addToBackStack("FragmentCow");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_func_2) {
            setTitle("Equipment list");
            Frag_1_1 fragment = new Frag_1_1();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.tabs_1, fragment, "FragmentTwo");
            fragmentTransaction.addToBackStack("FragmentTwo");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_func_3) {
            setTitle("Map");
            Frag_1_2 fragment = new Frag_1_2();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.tabs_1, fragment, "Map");
            fragmentTransaction.addToBackStack("Map");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_func_4) {
            setTitle("Timeline");
            Frag_1_3 fragment = new Frag_1_3();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.tabs_1, fragment, "Timeline");
            fragmentTransaction.addToBackStack("Timeline");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}